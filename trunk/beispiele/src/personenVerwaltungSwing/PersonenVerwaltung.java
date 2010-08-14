package personenVerwaltungSwing;

import java.util.List;

public interface PersonenVerwaltung
{
    public void einfuegen(Person p) throws PersonenVerwaltungsException;
    public List<Person> liste() throws PersonenVerwaltungsException;
}
