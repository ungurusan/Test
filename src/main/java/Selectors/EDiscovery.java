package Selectors;

/**
 * Created by Alin on 6/30/2016.
 */
public class EDiscovery {
    public static String eDiscoveryTab = "/html/body/div/div[2]/div[1]/div/div/div[3]/ul/li[4]/a";
    public static String eDiscoveryTitle = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[1]/breadcrumb/ul/li[1]/a";
    public static String production = "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[2]/a/span";
    public static String custodians = "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[3]/a/span";
    public static String newProduction = "div[title=\"Create new Production\"]";
    public static String createNewMatter = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div";
    public static String matterName = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input";
    public static String matterDescription = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input";
    public static String firstIndexCheckbox = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/div/div/p[1]/input";
    public static String batesCheckbox = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input";
    public static String batesMask = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input";
    public static String batesLocation = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/select/option[2]";
    public static String batesColor = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/select/option[3]";
    public static String batesFont = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/select/option[3]";
    public static String batesLocationEdit = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/select/option[1]";
    public static String batesColorEdit = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/select/option[2]";
    public static String batesFontEdit = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/select/option[2]";
    public static String batesSave = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div";
    public static String batesDeleteYes = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel/edit-panel/div/div/div/div[4]/div/div[2]/div/i";
    public static String matterNameString = "//div[text()=\"Selenium Test Matter\"]";
    public static String matterNameStringEdit = "//div[text()=\"Selenium Test MatterEdited\"]";
    public static String matterDeleteButton = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div[4]/div[1]/div/div[4]/div/div[4]/div/i";
    public static String matterEditButton = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div[4]/div[1]/div/div[3]/div/div[3]/div";
    public static String mattersTitle = "//span[text()=\"Matters\"]";
    public static String xButton = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[1]/div/div[2]/div/i";

    public static String newProductionMatterDropdown = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/select";
    public static String newProductionName = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input";
    public static String newProductionDescription = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/input";
    public static String newProductionSave = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div";
    public static String productionNameCheck = "//div[text()=\"DOD Investigation\"]";
    public static String refresh = "div[title=\"Refresh the matters and productions list\"]";
    public static String delete = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[2]/div[2]/div/div[2]/div[7]/div/div[4]/div/i";
    public static String deleteConfirmation = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel/edit-panel/div/div/div/div[4]/div/div[2]/div";
    public static String expandProduction = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[3]/div/div/div";

}
