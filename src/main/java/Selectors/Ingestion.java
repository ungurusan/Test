package Selectors;

/**
 * Created by Flaviu on 6/28/2016.
 */
public class Ingestion {
    public static  String ingestionSelector = "/html/body/div/div[2]/div[1]/div/div/div[3]/ul/li[2]/a";
    public static  String ingestionCreateNew = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div";
    public static String ingestionRefresh = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div";
    public static String streamsTitle = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[1]/breadcrumb/ul/li[2]/span";

    static public String streamId = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[1]/span";
    static public String editStream = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[8]/div/div[1]/div/i";
    static public String clearStream = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[8]/div/div[2]/div/i";
    static public String itemsCount = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[4]/span";
    static public String itemsSize = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[5]/span";
    static public String lastActivity = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[6]/span";
    static public String deleteStream = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[7]/div[8]/div/div[3]/div/i";

    static public String streamTable = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div";


    //Add New Stream
    static public String streamName = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input";
    static public String streamDescription = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input";
    //Stream Types
    static public String getStreamDropdown = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select";
    static public String streamTypeEmailArchive = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[2]";
    static public String streamTypeJournal = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[1]";
    static public String streamDesktopDocuments = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[3]";
    static public String streamNotesJournal = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[4]";
    static public String streamPSTItems = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[5]";
    static public String streamPSTContainer = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[6]";
    static public String streamNotesNSFItemLevel = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[7]";
    static public String streamNotesNSFContainerLevel = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select/option[8]";

    static public String streamHelp = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[3]/i";
    static public String streamCreationClose = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[1]/div/div[2]/div/i";
    static public String streamSave = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div";
    static public String streamCancel = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[1]/div";

    //Confirmation
    public static String confirmationYes = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[2]/edit-panel/div/div/div/div[4]/div/div[2]/div";
    public static String confirmationNo = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[2]/edit-panel/div/div/div/div[4]/div/div[1]/div";

    //Deletion

    public static String deleteButton = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div/div[5]/div[8]/div/div[3]/div/i";

}
