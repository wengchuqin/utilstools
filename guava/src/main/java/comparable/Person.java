package comparable;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

class Person implements Comparable<Person> {
    private String lastName;
    private String firstName;
    private int zipCode;


    public int compareTo(Person that) {
        return ComparisonChain.start()
                .compare(lastName, that.lastName)
                .compare(firstName, that.firstName)
                .compare(zipCode, zipCode, Ordering.<Integer>natural().nullsLast())
                .result();
    }
}
