package by.tms.store;

import by.tms.entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryAccountRepository {
    private static final List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Optional<Account> findByEmail(String email) {
        for (Account account: accounts) {
            if (account.getEmail().equals(email)) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }
}
