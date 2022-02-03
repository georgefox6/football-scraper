import Models.Player;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HtmlUnitScraper {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("footballscraper");
    static EntityManager em = emf.createEntityManager();

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static int getStandardStats(HtmlPage htmlPage) {
        int firstPlayerId = 0;

        String teamName = htmlPage.getTitleText().replace(" Stats, Premier League | FBref.com", "").replace("2021-2022 ", "");

        final HtmlTable table = htmlPage.getHtmlElementById("stats_standard_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            Player player = new Player();
            player.setPlayerName(row.getCell(0).asNormalizedText());
            player.setPlayerNation(row.getCell(1).asNormalizedText());
            player.setPlayerPosition(row.getCell(2).asNormalizedText());
            player.setPlayerAge(row.getCell(3).asNormalizedText());
            player.setPlayerTeam(teamName);
            try {
                player.setMatchesPlayed(Integer.parseInt(row.getCell(4).asNormalizedText()));
                player.setMatchesStarted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                player.setMinutesPlayed(Integer.parseInt(row.getCell(6).asNormalizedText().replace(",", "")));
                player.setGoals(Integer.parseInt(row.getCell(8).asNormalizedText()));
                player.setAssists(Integer.parseInt(row.getCell(9).asNormalizedText()));
                player.setExpectedGoals(Double.parseDouble(row.getCell(20).asNormalizedText()));
                player.setExpectedAssists(Double.parseDouble(row.getCell(22).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setMatchesPlayed(0);
                player.setMatchesStarted(0);
                player.setMinutesPlayed(0);
                player.setGoals(0);
                player.setAssists(0);
                player.setExpectedGoals(0);
                player.setExpectedAssists(0);
            }

            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(player);

            if (firstPlayerId == 0) {
                firstPlayerId = player.getId();
            }

            em.getTransaction().commit();
        }
        return firstPlayerId;
    }

    public static void getShootingStats(HtmlPage htmlPage, int firstPlayerId) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_shooting_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            //Read Player
            //retrieve player with id equal to firstPlayerId
            Player player = em.find(Player.class, firstPlayerId);

            firstPlayerId++;

            try {
                player.setShots(Integer.parseInt(row.getCell(6).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setShots(0);
            }
            try {
                player.setShotsOnTarget(Integer.parseInt(row.getCell(7).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setShotsOnTarget(0);
            }
            try {
                player.setShotDistance(Double.parseDouble(row.getCell(13).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setShotDistance(0.0);
            }
            try {
                player.setFreeKickShots(Integer.parseInt(row.getCell(14).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setFreeKickShots(0);
            }
            try {
                player.setPenaltyScored(Integer.parseInt(row.getCell(15).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setPenaltyScored(0);
            }
            try {
                player.setPenaltyShots(Integer.parseInt(row.getCell(16).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setPenaltyShots(0);
            }

            //Save the updated player in the database
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
    }

    public static void getPassingStats(HtmlPage htmlPage, int firstPlayerId) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_passing_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            //Read Player
            //retrieve player with id equal to firstPlayerId
            Player player = em.find(Player.class, firstPlayerId);

            firstPlayerId++;

            try {
                player.setTotalPassesCompleted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                player.setTotalPassesAttempted(Integer.parseInt(row.getCell(6).asNormalizedText()));

                player.setShortPassesCompleted(Integer.parseInt(row.getCell(10).asNormalizedText()));
                player.setShortPassesAttempted(Integer.parseInt(row.getCell(11).asNormalizedText()));

                player.setMediumPassesCompleted(Integer.parseInt(row.getCell(13).asNormalizedText()));
                player.setMediumPassesAttempted(Integer.parseInt(row.getCell(14).asNormalizedText()));

                player.setLongPassesCompleted(Integer.parseInt(row.getCell(16).asNormalizedText()));
                player.setLongPassesAttempted(Integer.parseInt(row.getCell(17).asNormalizedText()));

                player.setProgressivePassingDistance(Integer.parseInt(row.getCell(9).asNormalizedText()));

            } catch (NumberFormatException e) {
                player.setTotalPassesCompleted(0);
                player.setTotalPassesAttempted(0);

                player.setShortPassesCompleted(0);
                player.setShortPassesAttempted(0);

                player.setMediumPassesCompleted(0);
                player.setMediumPassesAttempted(0);

                player.setLongPassesCompleted(0);
                player.setLongPassesAttempted(0);

                player.setProgressivePassingDistance(0);
            }

            //Save the updated player in the database
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
    }

    public static void getDefenseStats(HtmlPage htmlPage, int firstPlayerId) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_defense_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            //Read Player
            //retrieve player with id equal to firstPlayerId
            Player player = em.find(Player.class, firstPlayerId);

            firstPlayerId++;

            try {
                player.setTacklesAttempted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                player.setTacklesWon(Integer.parseInt(row.getCell(6).asNormalizedText()));
                player.setTacklesDefensiveThird(Integer.parseInt(row.getCell(7).asNormalizedText()));
                player.setTacklesMiddleThird(Integer.parseInt(row.getCell(8).asNormalizedText()));
                player.setTacklesAttackingThird(Integer.parseInt(row.getCell(8).asNormalizedText()));
                player.setInterceptions(Integer.parseInt(row.getCell(24).asNormalizedText()));
                player.setPressuresAttempted(Integer.parseInt(row.getCell(14).asNormalizedText()));
                player.setPressuresWon(Integer.parseInt(row.getCell(15).asNormalizedText()));
                player.setPressuresDefensiveThird(Integer.parseInt(row.getCell(17).asNormalizedText()));
                player.setPressuresMiddleThird(Integer.parseInt(row.getCell(18).asNormalizedText()));
                player.setPressuresAttackingThird(Integer.parseInt(row.getCell(19).asNormalizedText()));
                player.setBlocks(Integer.parseInt(row.getCell(20).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setTacklesAttempted(0);
                player.setTacklesWon(0);
                player.setTacklesDefensiveThird(0);
                player.setTacklesMiddleThird(0);
                player.setTacklesAttackingThird(0);
                player.setInterceptions(0);
                player.setPressuresAttempted(0);
                player.setPressuresWon(0);
                player.setPressuresDefensiveThird(0);
                player.setPressuresMiddleThird(0);
                player.setPressuresAttackingThird(0);
                player.setBlocks(0);
            }

            //Save the updated player in the database
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
    }

    public static void getPossessionStats(HtmlPage htmlPage, int firstPlayerId) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_possession_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            //Read Player
            //retrieve player with id equal to firstPlayerId
            Player player = em.find(Player.class, firstPlayerId);

            firstPlayerId++;

            try {
                player.setDribblesAttempted(Integer.parseInt(row.getCell(13).asNormalizedText()));
                player.setDribblesCompleted(Integer.parseInt(row.getCell(12).asNormalizedText()));
                player.setDribblesProgressiveDistance(Integer.parseInt(row.getCell(19).asNormalizedText()));
                player.setProgressiveDribbles(Integer.parseInt(row.getCell(20).asNormalizedText()));
                player.setPassesReceived(Integer.parseInt(row.getCell(25).asNormalizedText()));
                player.setPassesControlled(Integer.parseInt(row.getCell(26).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setDribblesAttempted(0);
                player.setDribblesCompleted(0);
                player.setDribblesProgressiveDistance(0);
                player.setProgressiveDribbles(0);
                player.setPassesReceived(0);
                player.setPassesControlled(0);
            }

            //Save the updated player in the database
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
    }

    public static void getMiscStats(HtmlPage htmlPage, int firstPlayerId) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_misc_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            //Read Player
            //retrieve player with id equal to firstPlayerId
            Player player = em.find(Player.class, firstPlayerId);

            firstPlayerId++;

            try {
                player.setYellowCards(Integer.parseInt(row.getCell(5).asNormalizedText()));
                player.setRedCards(Integer.parseInt(row.getCell(6).asNormalizedText()));
                player.setHeadersWon(Integer.parseInt(row.getCell(18).asNormalizedText()));
                player.setHeadersLost(Integer.parseInt(row.getCell(19).asNormalizedText()));
                player.setFouls(Integer.parseInt(row.getCell(8).asNormalizedText()));
                player.setCrosses(Integer.parseInt(row.getCell(11).asNormalizedText()));
            } catch (NumberFormatException e) {
                player.setYellowCards(0);
                player.setRedCards(0);
                player.setHeadersWon(0);
                player.setHeadersLost(0);
                player.setFouls(0);
                player.setCrosses(0);
            }

            //Save the updated player in the database
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        }
    }

    public static void getTransferStats(HtmlPage htmlPage) {


        final HtmlTable table = htmlPage.getFirstByXPath("//*[@id=\"yw1\"]/table");

        for (final HtmlTableRow row : table.getRows().subList(1, table.getRowCount())) {

            String name = row.getCell(1).asNormalizedText().split("\\r?\\n")[0].trim();

            //Special Exceptions
            if (name.equals("Heung-min Son")) {
                name = "Son Heung-min";
            }

            if (name.equals("Raphinha")) {
                name = "Raphael Dias Belloli";
            }

            if (name.equals("Gabriel")) {
                name = "Gabriel Dos Santos";
            }

            if (name.equals("Thiago")) {
                name = "Thiago Alcántara";
            }

            int height = 0;
            if (!row.getCell(4).asNormalizedText().replace(",", "").replace("m", "").trim().equals("")) {
                height = Integer.parseInt(row.getCell(4).asNormalizedText().replace(",", "").replace("m", "").trim());
            }
            String preferredFoot = row.getCell(5).asNormalizedText();
            String contractEndDate = row.getCell(8).asNormalizedText();
            String marketValueString = row.getCell(9).asNormalizedText();

            int marketValue = 0;
            if (marketValueString.contains("m")) {
                marketValue = (int) (Double.parseDouble(marketValueString.substring(1, marketValueString.indexOf('m'))) * 1000000);
            } else if (marketValueString.contains("Th")) {
                marketValue = (int) (Double.parseDouble(marketValueString.substring(1, marketValueString.indexOf('T'))) * 1000);
            }

            name = StringUtils.stripAccents(name);

            try {

                List<Player> playerList = findPlayer(name);
                if (playerList == null || playerList.isEmpty()) {
                    System.out.println("Player not found in the db - " + name);
                    continue;
                }
                for (Player player : playerList) {


                    player.setHeight(height);
                    player.setPreferredFoot(preferredFoot);
                    player.setContractEndDate(contractEndDate);
                    player.setMarketValue(marketValue);

                    //Save the updated player in the database
                    em.getTransaction().begin();
                    em.merge(player);
                    em.getTransaction().commit();
                }


            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }

        }

    }

    private static void getSalaryStats(HtmlPage htmlPage) {

        final HtmlTable table = htmlPage.getFirstByXPath("//*[@id=\"gatsby-focus-wrapper\"]/div[2]/main/div[1]/div/div[2]/div[3]/table");

        try {
            for (final HtmlTableRow row : table.getRows().subList(1, table.getRowCount())) {
                try {

                    String name = row.getCell(0).asNormalizedText();
                    String wageString = row.getCell(1).asNormalizedText();
                    int wage = Integer.parseInt(wageString.replace("£", "").replace(",", "").trim());

                    //Special Exceptions
                    if (name.equals("Heung-min Son")) {
                        name = "Son Heung-min";
                    }

                    if (name.equals("Raphinha")) {
                        name = "Raphael Dias Belloli";
                    }

                    if (name.equals("Gabriel")) {
                        name = "Gabriel Dos Santos";
                    }

                    if (name.equals("Thiago")) {
                        name = "Thiago Alcántara";
                    }

                    List<Player> playerList = findPlayer(name);

                    if (playerList == null || playerList.isEmpty()) {
                        continue;
                    }
                    for (Player player : playerList) {
                        player.setWage(wage);

                        //Save the updated player in the database
                        em.getTransaction().begin();
                        em.merge(player);
                        em.getTransaction().commit();
                    }

                } catch (IndexOutOfBoundsException ex) {
                    //                ex.printStackTrace();
                }
            }

            final HtmlTable secondTable = htmlPage.getFirstByXPath("//*[@id=\"gatsby-focus-wrapper\"]/div[2]/main/div[1]/div/div[2]/div[5]/table");

            for (final HtmlTableRow row : secondTable.getRows().subList(1, table.getRowCount())) {
                try {
                    String name = row.getCell(0).asNormalizedText();
                    String wageString = row.getCell(1).asNormalizedText();
                    int wage = Integer.parseInt(wageString.replace("£", "").replace(",", "").trim());

                    Player player = null;

                    if (!queryForPlayersByName(name).isEmpty()) {
                        player = queryForPlayersByName(name).get(0);
                    }

                    if (player == null) {
                        continue;
                    }
                    player.setWage(wage);

                    //Save the updated player in the database
                    em.getTransaction().begin();
                    em.merge(player);
                    em.getTransaction().commit();

                } catch (IndexOutOfBoundsException ex) {
//                ex.printStackTrace();
                }
            }
        } catch (Exception ex) {

        }

    }

    public static List<String> getFBRefLinks() {
        List<String> premierLeagueUrlFBRef = new ArrayList<>();
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/cff3d9bb/Chelsea-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/b8fd03ef/Manchester-City-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/7c21e445/West-Ham-United-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/822bd0ba/Liverpool-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/18bb7c10/Arsenal-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/19538871/Manchester-United-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/d07537b9/Brighton-and-Hove-Albion-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/8cec06e1/Wolverhampton-Wanderers-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/361ca564/Tottenham-Hotspur-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/47c64c55/Crystal-Palace-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/d3fd31cc/Everton-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/a2d435b3/Leicester-City-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/33c895d4/Southampton-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/cd051869/Brentford-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/5bfb9659/Leeds-United-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/8602292d/Aston-Villa-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/2abfe087/Watford-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/943e8050/Burnley-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/b2b47a98/Newcastle-United-Stats");
        premierLeagueUrlFBRef.add("https://fbref.com/en/squads/1c781004/Norwich-City-Stats");

        return premierLeagueUrlFBRef;
    }

    public static List<String> getTransfermarktLinks() {
        List<String> transfermarktLinks = new ArrayList<>();
        transfermarktLinks.add("https://www.transfermarkt.co.uk/manchester-city/kader/verein/281/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/manchester-united/kader/verein/985/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/chelsea-fc/kader/verein/631/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/liverpool-fc/kader/verein/31/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/tottenham-hotspur/kader/verein/148/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/arsenal-fc/kader/verein/11/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/leicester-city/kader/verein/1003/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/everton-fc/kader/verein/29/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/aston-villa/kader/verein/405/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/wolverhampton-wanderers/kader/verein/543/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/west-ham-united/kader/verein/379/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/leeds-united/kader/verein/399/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/brighton-amp-hove-albion/kader/verein/1237/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/southampton-fc/kader/verein/180/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/crystal-palace/kader/verein/873/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/newcastle-united/kader/verein/762/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/brentford-fc/kader/verein/1148/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/norwich-city/kader/verein/1123/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/watford-fc/kader/verein/1010/saison_id/2021/plus/1");
        transfermarktLinks.add("https://www.transfermarkt.co.uk/burnley-fc/kader/verein/1132/saison_id/2021/plus/1");

        return transfermarktLinks;
    }

    private static List<String> getSalarySportLinks() {
        List<String> salarySportLinks = new ArrayList<>();
        salarySportLinks.add("https://salarysport.com/football/sky-bet-championship/norwich-city/");
        salarySportLinks.add("https://salarysport.com/football/premier-league/crystal-palace/");
        salarySportLinks.add("https://salarysport.com/football/premier-league/leicester-city/");
        salarySportLinks.add("https://salarysport.com/football/premier-league/arsenal-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/aston-villa-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/brighton-&-hove-albion/");
        salarySportLinks.add("https://salarysport.com/football/premier-league/burnley-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/chelsea-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/everton-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/leeds-united/");
        salarySportLinks.add("https://salarysport.com/football/premier-league/liverpool-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/manchester-city-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/manchester-united-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/newcastle-united-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/southampton-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/tottenham-hotspur-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/west-ham-united-f.c./");
        salarySportLinks.add("https://salarysport.com/football/premier-league/wolverhampton-wanderers-f.c./");
        salarySportLinks.add("https://salarysport.com/football/sky-bet-championship/brentford/");
        salarySportLinks.add("https://salarysport.com/football/sky-bet-championship/watford/");

        return salarySportLinks;
    }

    public static void main(String[] args) throws Exception {

        //Create new webclient
        WebClient webClient = new WebClient();
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        List<String> premierLeagueUrlFBRef = getFBRefLinks();

        for (String teamUrl : premierLeagueUrlFBRef) {
            HtmlPage htmlPage = webClient.getPage(teamUrl);

            int firstPlayerId = getStandardStats(htmlPage);


            getShootingStats(htmlPage, firstPlayerId);
            getPassingStats(htmlPage, firstPlayerId);
            getDefenseStats(htmlPage, firstPlayerId);
            getPossessionStats(htmlPage, firstPlayerId);
            getMiscStats(htmlPage, firstPlayerId);

            System.out.println("Completed FB REF - " + teamUrl);
        }

        List<String> transfermarktPages = getTransfermarktLinks();

        for (String page : transfermarktPages) {

            HtmlPage htmlPage = webClient.getPage(page);
            getTransferStats(htmlPage);

            System.out.println("Completed Transfermarkt - " + page);

        }

        List<String> salarySportLinks = getSalarySportLinks();

        for (String page : salarySportLinks) {

            HtmlPage htmlPage = webClient.getPage(page);
            getSalaryStats(htmlPage);

            System.out.println("Completed Salary Sport - " + page);
        }
    }

    public static List<Player> queryForPlayersByName(String name) {
        EntityManager em = getEntityManager();
        List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName = ?1 collate utf8mb4_0900_ai_ci", Player.class)
                .setParameter(1, name)
                .getResultList();
        return players;
    }

    public static List<Player> queryForPlayersByNameLast(String name) {
        if (name.split(" ").length > 1) {
            EntityManager em = getEntityManager();
            List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName like ?1 collate utf8mb4_0900_ai_ci", Player.class)
                    .setParameter(1, '%' + name.split(" ")[1])
                    .getResultList();
            return players;
        }
        return null;
    }

    public static List<Player> queryForPlayersByNameFirst(String name) {
        EntityManager em = getEntityManager();
        List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName like ?1 collate utf8mb4_0900_ai_ci", Player.class)
                .setParameter(1, name.split(" ")[0] + '%')
                .getResultList();
        return players;
    }

    public static List<Player> queryForPlayersByNameSwapped(String name) {
        if (name.split(" ").length > 1) {
            EntityManager em = getEntityManager();
            List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName = ?1 collate utf8mb4_0900_ai_ci", Player.class)
                    .setParameter(1, name.split(" ")[1] + name.split(" ")[0])
                    .getResultList();
            return players;
        }
        return null;
    }

    public static List<Player> queryForPlayersByJustLastName(String name) {
        if (name.split(" ").length > 1) {
            EntityManager em = getEntityManager();
            List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName like ?1 collate utf8mb4_0900_ai_ci", Player.class)
                    .setParameter(1, '%' + name.split(" ")[1] + '%')
                    .getResultList();
            return players;
        }
        return null;
    }

    public static List<Player> queryForPlayersByJustFirstName(String name) {
        EntityManager em = getEntityManager();
        List<Player> players = em.createNativeQuery("SELECT * FROM players players where players.playerName like ?1 collate utf8mb4_0900_ai_ci", Player.class)
                .setParameter(1, '%' + name.split(" ")[0] + '%')
                .getResultList();
        return players;
    }

    public static List<Player> findPlayer(String name) {
        List<Player> playerList = null;
        try {
            playerList = queryForPlayersByName(name);


            if (playerList.isEmpty()) {
                playerList = queryForPlayersByNameLast(name);
                if (playerList.isEmpty()) {
                    playerList = queryForPlayersByNameFirst(name);
                    if (playerList.isEmpty()) {
                        playerList = queryForPlayersByNameSwapped(name);
                        if (playerList.isEmpty()) {
                            playerList = queryForPlayersByJustLastName(name);
                            if (playerList.isEmpty()) {
                                playerList = queryForPlayersByJustFirstName(name);
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error with player - " + name);
        }


        if (playerList == null || playerList.isEmpty()) {
            return null;
        }
        return playerList;
    }
}