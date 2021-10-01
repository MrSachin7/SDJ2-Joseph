package client.model;

public interface Model
{
   void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException;
}
