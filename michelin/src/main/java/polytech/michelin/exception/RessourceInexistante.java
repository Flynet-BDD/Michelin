package polytech.michelin.exception;

public class RessourceInexistante extends RuntimeException
{
    public RessourceInexistante(String message)
    {
        super(message);
    }
}
