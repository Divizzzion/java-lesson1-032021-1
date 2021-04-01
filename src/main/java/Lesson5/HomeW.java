package Lesson5;

public class HomeW {
    public static void main(String[] args) {

        // Создать массив из 5 сотрудников
        Person[] persArray = new Person[5];
        createDataBase(persArray);

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет
        printPersonOlder40(persArray);
    }

    static void createDataBase(Person[] persArray)
    {
        persArray[0] = new Person("Соколов Антон", "Инженер", "sa@personmail.com", "+70091234554",
                100000, 28);

        persArray[1] = new Person("Антонов Петр", "Программист", "ap@personmail.com",
                "+70091235665", 80000, 46);

        persArray[2] = new Person("Петров Антон", "Инженер", "pa@personmail.com",
                "+70091234664", 80000, 22);

        persArray[3] = new Person("Константинов Сергей", "Программист", "ks@personmail.com",
                "+70091236446", 70000, 56);

        persArray[4] = new Person("Сергеев Константин", "Системный администратор", "sk@personmail.com",
                "+70091237997", 100000, 48);
    }

    static void printPersonOlder40(Person[] persArray)
    {
        for(int i = 0; i < persArray.length; i++)
        {
            if( persArray[i].getAge() > 40 )
            {
                persArray[i].printInfo();
            }
        }

    }
}

