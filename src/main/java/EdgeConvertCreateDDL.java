import javax.swing.JOptionPane;

public abstract class EdgeConvertCreateDDL {
   static String[] products = {"MySQL"};
   protected EdgeTable[] tables; //master copy of EdgeTable objects
   protected EdgeField[] fields; //master copy of EdgeField objects
   protected int[] numBoundTables;
   protected int maxBound;
   protected StringBuffer sb;
   protected int selected;
   protected String databaseName;
   
   public EdgeConvertCreateDDL(EdgeTable[] tables, EdgeField[] fields) {
      this.tables = tables;
      this.fields = fields;
      initialize();
   } //EdgeConvertCreateDDL(EdgeTable[], EdgeField[])
   
   public EdgeConvertCreateDDL() { //default constructor with empty arg list for to allow output dir to be set before there are table and field objects
      
   } //EdgeConvertCreateDDL()

   public void initialize() {
      numBoundTables = new int[tables.length];
      maxBound = 0;
      sb = new StringBuffer();

      for (int i = 0; i < tables.length; i++) { //step through list of tables
         int numBound = 0; //initialize counter for number of bound tables
         int[] relatedFields = tables[i].getRelatedFieldsArray();
         for (int j = 0; j < relatedFields.length; j++) { //step through related fields list
            if (relatedFields[j] != 0) {
               numBound++; //count the number of non-zero related fields
            }
         }
         numBoundTables[i] = numBound;
         if (numBound > maxBound) {
            maxBound = numBound;
         }
      }
   }
   
   protected EdgeTable getTable(int numFigure) {
      for (int tIndex = 0; tIndex < tables.length; tIndex++) {
         if (numFigure == tables[tIndex].getNumFigure()) {
            return tables[tIndex];
         }
      }
      return null;
   }
   
   protected EdgeField getField(int numFigure) {
      for (int fIndex = 0; fIndex < fields.length; fIndex++) {
         if (numFigure == fields[fIndex].getNumFigure()) {
            return fields[fIndex];
         }
      }
      return null;
   }
   
  public String generateDatabaseName() { //prompts user for database name
	      String dbNameDefault = "MySQLDB";
	      //String databaseName = "";

	      do {
	         databaseName = (String)JOptionPane.showInputDialog(
	                       null,
	                       "Enter the database name:",
	                       "Database Name",
	                       JOptionPane.PLAIN_MESSAGE,
	                       null,
	                       null,
	                       dbNameDefault);
	         if (databaseName == null) {
	            EdgeConvertGUI.setReadSuccess(false);
	            return "";
	         }
	         if (databaseName.equals("")) {
	            JOptionPane.showMessageDialog(null, "You must select a name for your database.");
	         }
	      } while (databaseName.equals(""));
	      return databaseName;
	   }
  
  public String getDatabaseName() {
      return databaseName;
   }

   public abstract String getProductName();
   
   public abstract String getSQLString();
   
   public abstract void createDDL();
   
}//EdgeConvertCreateDDL
