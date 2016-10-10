package Selectors;

/**
 * Created by Alin on 6/28/2016.
 */
public class Dashboard {

    static public String dashboardSelector = "a[href*=dashboard]";
    static public String hourTransactions = "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[1]/a/span";
    static public String todayTransactions = "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[2]/a/span";
    static public String historyTransactions = "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[3]/a/span";
    static public String homepageButton = "/html/body/div/div[2]/div[1]/div/div/div[2]/div";
    static public String dashboardTitle = "/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[1]/breadcrumb/ul/li[2]/span";
}
