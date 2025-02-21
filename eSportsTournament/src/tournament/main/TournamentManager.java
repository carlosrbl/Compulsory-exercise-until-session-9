package tournament.main;

import tournament.data.*;

public class TournamentManager
{
    Player[] registeredPlayer = new Player[20];
    Team [] registeredTeam = new Team[10];
    Tournament [] registeredTournament = new Tournament[6];
    Match [] registeredMatch = new Match[4];

    public void initialize()
    {
        initializePlayers();





    }
    public void initializePlayers()
    {
        registeredPlayer[0] = new Player("Alejandro",12,453.1f);
        registeredPlayer[1] = new Player("Valeria",19,483.1f);
        registeredPlayer[2] = new Player("Mateo",52,899.0f);
        registeredPlayer[3] = new Player("Isabella",91,91.45f);
        registeredPlayer[4] = new Player("Santiago",23,532.2f);
        registeredPlayer[5] = new Player("Camila",99,222.2f);
        registeredPlayer[6] = new Player("Leonardo",38,753.3f);
        registeredPlayer[7] = new Player("Sofía",71,463.99f);
        registeredPlayer[8] = new Player("Andrés",88,441.1f);
        registeredPlayer[9] = new Player("Elena",4,82701.54f);
    }
    public void initializeTeam()
    {

    }
    public void initializeTournament()
    {

    }
    public void initializeMatch()
    {

    }
}
