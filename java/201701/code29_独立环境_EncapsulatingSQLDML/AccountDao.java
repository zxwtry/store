package step29EncapsulatingSQLDML;

public interface AccountDao {
    public long insert(Account account);
    public void delete(long id);
    public void update(Account account);
}
