import Models.Player;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HtmlUnitScraper {

    final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("footballscraper");
    final static EntityManager em = emf.createEntityManager();

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
        PlayerRepository playerRepository = new PlayerRepository(em);

        //Create new webclient
        WebClient webClient = new WebClient();
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        for (String page : getTransfermarktLinks()) {
            HtmlPage htmlPage = webClient.getPage(page);
            getTransferStatsNew(htmlPage, playerRepository);
        }

        for (String page : getSalarySportLinks()) {
            HtmlPage htmlPage = webClient.getPage(page);
            getSalaryStatsNew(htmlPage, playerRepository);
        }

        for (String teamUrl : getFBRefLinks()) {
            HtmlPage htmlPage = webClient.getPage(teamUrl);
            getStandardStatsNew(htmlPage, playerRepository);
            getShootingStatsNew(htmlPage, playerRepository);
            getPassingStatsNew(htmlPage, playerRepository);
            getDefenseStatsNew(htmlPage, playerRepository);
            getPossessionStatsNew(htmlPage, playerRepository);
            getMiscStatsNew(htmlPage, playerRepository);
        }
    }


    private static int calculateValue(String marketValueString){
        int marketValue = 0;
        if (marketValueString.contains("m")) {
            marketValue = (int) (Double.parseDouble(marketValueString.substring(1, marketValueString.indexOf('m'))) * 1000000);
        } else if (marketValueString.contains("Th")) {
            marketValue = (int) (Double.parseDouble(marketValueString.substring(1, marketValueString.indexOf('T'))) * 1000);
        }
        return marketValue;
    }

    private static int calculateHeight(String heightString){
        int height = 0;
        String number = heightString.replace(",", "").replace("m", "").trim();
        if (!number.equals("")) {
            height = Integer.parseInt(number);
        }
        return height;
    }

    private static String getNameExceptionsFBREF(String name){
        //FBREF -> DB
        return switch (name) {
            case "Son Heung-min" -> "Heung-min Son";
            case "Raphael Dias Belloli" -> "Raphinha";
            case "Pierre Højbjerg" -> "Pierre-Emile Höjbjerg";
            case "Emi Buendía" -> "Emiliano Buendía";
            case "Martinelli" -> "Gabriel Martinelli";
            case "Gabriel Dos Santos" -> "Gabriel";
            case "Thiago Alcántara" -> "Thiago";
            case "Valentino Livramento" -> "Tino Livramento";
            case "Rayan Aït Nouri" -> "Rayan Aït-Nouri";
            case "Kayky Chagas" -> "Kayky";
            case "Hwang Hee-chan" -> "Hee-chan Hwang";
            case "Kostas Tsimikas" -> "Konstantinos Tsimikas";
            case "Cucho" -> "Cucho Hernández";
            case "Emerson" -> "Emerson Royal";
            default -> name;
        };
    }

    private static String getNameExceptionsSalarySport(String name){
        //Salary Sport -> DB
        return switch (name) {
            case "Saúl" -> "Saúl Ñíguez";
            case "Ebere Eze" -> "Eberechi Eze";
            case "Matthew Targett" -> "Matt Targett";
            case "Hwang Hee-Chan" -> "Hee-chan Hwang";
            case "Moi Elyounoussi" -> "Mohamed Elyounoussi";
            case "Kostas Tsimikas" -> "Konstantinos Tsimikas";
            case "Cédric" -> "Cédric Soares";
            case "Javi Manquillo" -> "Javier Manquillo";
            case "Matt Lowton" -> "Matthew Lowton";
            default -> name;
        };
    }

    private static void getSalaryStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final List<HtmlTable> tables = new ArrayList<>();
        tables.add(htmlPage.getFirstByXPath("//*[@id=\"gatsby-focus-wrapper\"]/div[2]/main/div[1]/div/div[2]/div[3]/table"));
        tables.add(htmlPage.getFirstByXPath("//*[@id=\"gatsby-focus-wrapper\"]/div[2]/main/div[1]/div/div[2]/div[5]/table"));

        for(HtmlTable table : tables){
            for (final HtmlTableRow row : table.getRows().subList(1, table.getRowCount())) {
                try {
                    String name = getNameExceptionsSalarySport(row.getCell(0).asNormalizedText());
                    String wageString = row.getCell(1).asNormalizedText();
                    int wage = Integer.parseInt(wageString.replace("£", "").replace(",", "").trim());

                    Optional<Player> player = playerRepository.findByName(name);

                    player.ifPresent(p -> {
                        p.setWage(wage);
                        playerRepository.save(p);
                    });
                } catch (IndexOutOfBoundsException ex) {
//                    ex.printStackTrace();
                }
            }
        }
    }

    private static void getTransferStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getFirstByXPath("//*[@id=\"yw1\"]/table");

        for (final HtmlTableRow row : table.getRows().subList(1, table.getRowCount())) {

            String name = row.getCell(1).asNormalizedText().split("\\r?\\n")[0].trim();
            String preferredFoot = row.getCell(5).asNormalizedText();
            String contractEndDate = row.getCell(8).asNormalizedText();
            int marketValue = calculateValue(row.getCell(9).asNormalizedText());
            int height = calculateHeight(row.getCell(4).asNormalizedText());

            Player player = new Player();
            player.setPlayerName(name);
            player.setHeight(height);
            player.setPreferredFoot(preferredFoot);
            player.setContractEndDate(contractEndDate);
            player.setMarketValue(marketValue);

            playerRepository.save(player);
        }
    }

    private static String calculateNation(String nation){
        return switch (nation) {
            case "eng ENG" -> "gb-eng ENG";
            case "wls WAL" -> "gb-wls WAL";
            case "sct SCO" -> "gb-sct SCO";
            case "nir NIR" -> "eu NIR";
            default -> nation;
        };
    }

    public static void getStandardStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        String teamName = htmlPage.getTitleText().replace(" Stats, Premier League | FBref.com", "").replace("2021-2022 ", "");

        final HtmlTable table = htmlPage.getHtmlElementById("stats_standard_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {
            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            String playerNation = calculateNation(row.getCell(1).asNormalizedText());
            //TODO change the value of position to something more useful
            String playerPosition = row.getCell(2).asNormalizedText();
            //TODO change the value of age to something easier to understand
            String playerAge = row.getCell(3).asNormalizedText();

            Optional<Player> player = playerRepository.findByName(playerName);
            player.ifPresent( p -> {
                p.setPlayerNation(playerNation);
                p.setPlayerPosition(playerPosition);
                p.setPlayerAge(playerAge);
                p.setPlayerTeam(teamName);
                try {
                    p.setMatchesPlayed(Integer.parseInt(row.getCell(4).asNormalizedText()));
                    p.setMatchesStarted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                    p.setMinutesPlayed(Integer.parseInt(row.getCell(6).asNormalizedText().replace(",", "")));
                    p.setGoals(Integer.parseInt(row.getCell(8).asNormalizedText()));
                    p.setAssists(Integer.parseInt(row.getCell(9).asNormalizedText()));
                    p.setExpectedGoals(Double.parseDouble(row.getCell(20).asNormalizedText()));
                    p.setExpectedAssists(Double.parseDouble(row.getCell(22).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setMatchesPlayed(0);
                    p.setMatchesStarted(0);
                    p.setMinutesPlayed(0);
                    p.setGoals(0);
                    p.setAssists(0);
                    p.setExpectedGoals(0);
                    p.setExpectedAssists(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }

    public static void getShootingStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_shooting_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            Optional<Player> player = playerRepository.findByName(playerName);

            player.ifPresent( p -> {
                try {
                    p.setShots(Integer.parseInt(row.getCell(6).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setShots(0);
                }
                try {
                    p.setShotsOnTarget(Integer.parseInt(row.getCell(7).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setShotsOnTarget(0);
                }
                try {
                    p.setShotDistance(Double.parseDouble(row.getCell(13).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setShotDistance(0.0);
                }
                try {
                    p.setFreeKickShots(Integer.parseInt(row.getCell(14).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setFreeKickShots(0);
                }
                try {
                    p.setPenaltyScored(Integer.parseInt(row.getCell(15).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setPenaltyScored(0);
                }
                try {
                    p.setPenaltyShots(Integer.parseInt(row.getCell(16).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setPenaltyShots(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }

    public static void getPassingStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_passing_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            Optional<Player> player = playerRepository.findByName(playerName);

            player.ifPresent( p -> {
                try {
                    p.setTotalPassesCompleted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                    p.setTotalPassesAttempted(Integer.parseInt(row.getCell(6).asNormalizedText()));
                    p.setShortPassesCompleted(Integer.parseInt(row.getCell(10).asNormalizedText()));
                    p.setShortPassesAttempted(Integer.parseInt(row.getCell(11).asNormalizedText()));
                    p.setMediumPassesCompleted(Integer.parseInt(row.getCell(13).asNormalizedText()));
                    p.setMediumPassesAttempted(Integer.parseInt(row.getCell(14).asNormalizedText()));
                    p.setLongPassesCompleted(Integer.parseInt(row.getCell(16).asNormalizedText()));
                    p.setLongPassesAttempted(Integer.parseInt(row.getCell(17).asNormalizedText()));
                    p.setProgressivePassingDistance(Integer.parseInt(row.getCell(9).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setTotalPassesCompleted(0);
                    p.setTotalPassesAttempted(0);
                    p.setShortPassesCompleted(0);
                    p.setShortPassesAttempted(0);
                    p.setMediumPassesCompleted(0);
                    p.setMediumPassesAttempted(0);
                    p.setLongPassesCompleted(0);
                    p.setLongPassesAttempted(0);
                    p.setProgressivePassingDistance(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }

    public static void getDefenseStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_defense_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            Optional<Player> player = playerRepository.findByName(playerName);

            player.ifPresent( p -> {
                try {
                    p.setTacklesAttempted(Integer.parseInt(row.getCell(5).asNormalizedText()));
                    p.setTacklesWon(Integer.parseInt(row.getCell(6).asNormalizedText()));
                    p.setTacklesDefensiveThird(Integer.parseInt(row.getCell(7).asNormalizedText()));
                    p.setTacklesMiddleThird(Integer.parseInt(row.getCell(8).asNormalizedText()));
                    p.setTacklesAttackingThird(Integer.parseInt(row.getCell(8).asNormalizedText()));
                    p.setInterceptions(Integer.parseInt(row.getCell(24).asNormalizedText()));
                    p.setPressuresAttempted(Integer.parseInt(row.getCell(14).asNormalizedText()));
                    p.setPressuresWon(Integer.parseInt(row.getCell(15).asNormalizedText()));
                    p.setPressuresDefensiveThird(Integer.parseInt(row.getCell(17).asNormalizedText()));
                    p.setPressuresMiddleThird(Integer.parseInt(row.getCell(18).asNormalizedText()));
                    p.setPressuresAttackingThird(Integer.parseInt(row.getCell(19).asNormalizedText()));
                    p.setBlocks(Integer.parseInt(row.getCell(20).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setTacklesAttempted(0);
                    p.setTacklesWon(0);
                    p.setTacklesDefensiveThird(0);
                    p.setTacklesMiddleThird(0);
                    p.setTacklesAttackingThird(0);
                    p.setInterceptions(0);
                    p.setPressuresAttempted(0);
                    p.setPressuresWon(0);
                    p.setPressuresDefensiveThird(0);
                    p.setPressuresMiddleThird(0);
                    p.setPressuresAttackingThird(0);
                    p.setBlocks(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }

    public static void getPossessionStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_possession_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            Optional<Player> player = playerRepository.findByName(playerName);

            player.ifPresent( p -> {
                try {
                    p.setDribblesAttempted(Integer.parseInt(row.getCell(13).asNormalizedText()));
                    p.setDribblesCompleted(Integer.parseInt(row.getCell(12).asNormalizedText()));
                    p.setDribblesProgressiveDistance(Integer.parseInt(row.getCell(19).asNormalizedText()));
                    p.setProgressiveDribbles(Integer.parseInt(row.getCell(20).asNormalizedText()));
                    p.setPassesReceived(Integer.parseInt(row.getCell(25).asNormalizedText()));
                    p.setPassesControlled(Integer.parseInt(row.getCell(26).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setDribblesAttempted(0);
                    p.setDribblesCompleted(0);
                    p.setDribblesProgressiveDistance(0);
                    p.setProgressiveDribbles(0);
                    p.setPassesReceived(0);
                    p.setPassesControlled(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }

    public static void getMiscStatsNew(HtmlPage htmlPage, PlayerRepository playerRepository) {

        final HtmlTable table = htmlPage.getHtmlElementById("stats_misc_11160");

        for (final HtmlTableRow row : table.getRows().subList(2, table.getRowCount() - 2)) {

            String playerName = getNameExceptionsFBREF(row.getCell(0).asNormalizedText());
            Optional<Player> player = playerRepository.findByName(playerName);

            player.ifPresent( p -> {
                try {
                    p.setYellowCards(Integer.parseInt(row.getCell(5).asNormalizedText()));
                    p.setRedCards(Integer.parseInt(row.getCell(6).asNormalizedText()));
                    p.setHeadersWon(Integer.parseInt(row.getCell(18).asNormalizedText()));
                    p.setHeadersLost(Integer.parseInt(row.getCell(19).asNormalizedText()));
                    p.setFouls(Integer.parseInt(row.getCell(8).asNormalizedText()));
                    p.setCrosses(Integer.parseInt(row.getCell(11).asNormalizedText()));
                } catch (NumberFormatException e) {
                    p.setYellowCards(0);
                    p.setRedCards(0);
                    p.setHeadersWon(0);
                    p.setHeadersLost(0);
                    p.setFouls(0);
                    p.setCrosses(0);
                }
            });

            player.ifPresent(playerRepository::save);
        }
    }
}