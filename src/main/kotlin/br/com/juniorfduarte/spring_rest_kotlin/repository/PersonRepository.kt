package br.com.juniorfduarte.spring_rest_kotlin.repository

import br.com.juniorfduarte.spring_rest_kotlin.domain.Person
import br.com.juniorfduarte.spring_rest_kotlin.enum.PersonGender
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class PersonRepository {

    private final val counter: AtomicLong = AtomicLong()

    private val count = 0L

    fun findById(id: Long): Person? {
        return peopleList().find { it.id == id }
    }

    private val person1 = Person(
        id = counter.incrementAndGet(),
        firstName = "Francisco",
        lastName = "Junior",
        address = "Endereço 123",
        gender = PersonGender.MALE
    )

    private val person2 = Person(
        id = counter.incrementAndGet(),
        firstName = "Aline",
        lastName = "Silva",
        address = "Endereço 123",
        gender = PersonGender.FEMALE
    )

    private val person3 = Person(
        id = counter.incrementAndGet(),
        firstName = "User 3",
        lastName = "Bla",
        address = "Endereço 332",
        gender = PersonGender.OTHER
    )

    private val person4 = Person(
        id = counter.incrementAndGet(),
        firstName = "User 4",
        lastName = "Other",
        address = "Endereço 333",
        gender = PersonGender.OTHER
    )

    private fun mockedPerson(i: Int) : Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "First Name $i"
        person.lastName = "Last name $i"
        person.address = "Some Address $i"
        person.gender = PersonGender.entries.shuffled().first()
        return person
    }

    fun generatePeopleList(): MutableList<Person> {
        val people = mutableListOf<Person>()

        people.add(person1)
        people.add(person2)

        for (i in 3..7) {
            val person = mockedPerson(i)
            people.add(person)
        }
        return people
    }

    fun peopleList() : MutableList<Person> {
        val people = mutableListOf<Person>()

        people.add(person1)
        people.add(person2)
        people.add(person3)
        people.add(person4)

        return people
    }
}