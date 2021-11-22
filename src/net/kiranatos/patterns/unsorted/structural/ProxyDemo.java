package net.kiranatos.patterns.unsorted.structural;

import java.util.Random;

public class ProxyDemo
{
    public static void Run() throws BadConnectionException {
        int opNum = 0;
        try
        {
            RobotBombDefuser proxy = new RobotBombDefuserProxy(41);
            proxy.WalkStraightForward(100);
            opNum++;
            proxy.TurnRight();
            opNum++;
            proxy.WalkStraightForward(5);
            opNum++;
            proxy.DefuseBomb();
            opNum++;
        }
        catch (BadConnectionException e)
        {
            System.out.println("Exception has been caught with message: " + e + ". Decided to have human operate robot there.");

            PlanB(opNum);
        }
    }

    private static void PlanB(int nextOperationNum) throws BadConnectionException {
        RobotBombDefuser humanOperatingRobotDirectly = new RobotBombDefuser();

        if (nextOperationNum == 0)
        {
            humanOperatingRobotDirectly.WalkStraightForward(100);
            nextOperationNum++;
        }
        if (nextOperationNum == 1)
        {
            humanOperatingRobotDirectly.TurnRight();
            nextOperationNum++;
        }
        if (nextOperationNum == 2)
        {
            humanOperatingRobotDirectly.WalkStraightForward(5);
            nextOperationNum++;
        }
        if (nextOperationNum == 3)
        {
            humanOperatingRobotDirectly.DefuseBomb();
        }
    }
}

class RobotBombDefuser
{
    private Random _random = new Random();
    private int _robotConfiguredWavelength = 41;
    private boolean _isConnected = false;

    public void ConnectWireless(int communicationWaveLength)
    {
        if (communicationWaveLength == _robotConfiguredWavelength)
        {
            _isConnected = IsConnectedImmitatingConnectivitiyIssues();
        }
    }
    public boolean IsConnected()
    {
        _isConnected = IsConnectedImmitatingConnectivitiyIssues();
        return _isConnected;
    }
    private boolean IsConnectedImmitatingConnectivitiyIssues()
    {
        return _random.nextInt(10) < 8; // immitates 40% good connection, aka. very bad
    }

    public void WalkStraightForward(int steps) throws BadConnectionException {
        System.out.printf("Did %d steps forward...\n", steps);
    }

    public void TurnRight() throws BadConnectionException {
        System.out.println("Turned right...");
    }

    public void TurnLeft() throws BadConnectionException {
        System.out.println("Turned left...");
    }

    public void DefuseBomb() throws BadConnectionException {
        System.out.println("Cut red or green or blue wire...");
    }
}
class RobotBombDefuserProxy extends RobotBombDefuser
{
    private RobotBombDefuser _robotBombDefuser;
    private int _communicationWaveLength;
    private int _connectionAttempts = 3;

    public RobotBombDefuserProxy(int communicationWaveLength)
    {
        _robotBombDefuser = new RobotBombDefuser();
        _communicationWaveLength = communicationWaveLength;
    }
    public void WalkStraightForward(int steps) throws BadConnectionException
    {
        EnsureConnectedWithRobot();
        _robotBombDefuser.WalkStraightForward(steps);
    }
    public void TurnRight() throws BadConnectionException {
        EnsureConnectedWithRobot();
        _robotBombDefuser.TurnRight();
    }
    public void TurnLeft() throws BadConnectionException {
        EnsureConnectedWithRobot();
        _robotBombDefuser.TurnLeft();
    }
    public void DefuseBomb() throws BadConnectionException {
        EnsureConnectedWithRobot();
        _robotBombDefuser.DefuseBomb();
    }
    private void EnsureConnectedWithRobot() throws BadConnectionException {
        if (_robotBombDefuser == null)
        {
            _robotBombDefuser = new RobotBombDefuser();
            _robotBombDefuser.ConnectWireless(_communicationWaveLength);
        }
        for (int i = 0; i < _connectionAttempts; i++)
        {
            if (_robotBombDefuser.IsConnected() != true)
            {
                _robotBombDefuser.ConnectWireless(_communicationWaveLength);
            }
            else
            {
                break;
            }
        }
        if (_robotBombDefuser.IsConnected() != true)
        {
            throw new BadConnectionException("No connection with remote bomb diffuser robot could be made after few attempts.");
        }
    }
}
class BadConnectionException extends Exception
{
    String message;
    public BadConnectionException(String message)
    {
        this.message = message;
    }
    public String toString(){
        return message;
    }
}