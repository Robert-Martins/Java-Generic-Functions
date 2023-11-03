import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionsTest {

    private static final String INITIAL_VALUE = "Initial Value";
    private static final String[] INITIAL_ARRAY = {INITIAL_VALUE};
    private static final Integer FIRST_ARRAY_INDEX = 0;
    private static final Integer SECOND_ARRAY_INDEX = 1;

    private static final String SUCCESSFUL = "Successful";
    private static final String SECONDARY = "Secondary";

    private static final List<String> EMPTY_LIST = new ArrayList<>();
    private static final List<String> NOT_EMPTY_LIST = List.of(INITIAL_VALUE, SUCCESSFUL);

    private static final Predicate<String> PREDICATE_THAT_IS_ALWAYS_TRUE = Objects::nonNull;
    private static final Predicate<String> PREDICATE_THAT_MAY_BE_TRUE = str -> str.equals(SUCCESSFUL);
    private static final Predicate<String> PREDICATE_THAT_IS_ALWAYS_FALSE = str -> str.equals(SECONDARY);

    @Test
    public void testAcceptTrue() {
        String[] value = INITIAL_ARRAY;
        Functions.acceptTrue(
                Boolean.TRUE,
                () -> value[0] = (SUCCESSFUL)
        );
        assertEquals(SUCCESSFUL, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testAcceptTrueOrElse() {
        String[] value = INITIAL_ARRAY;
        Functions.acceptTrueOrElse(
                Boolean.FALSE,
                () -> value[FIRST_ARRAY_INDEX] = (SUCCESSFUL),
                () -> value[FIRST_ARRAY_INDEX] = (SECONDARY)
        );
        assertEquals(SECONDARY, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testAcceptTrueOrElseThrow() {
        assertThrows(
            RuntimeException.class,
            () -> Functions.acceptTrueOrElseThrow(
                        Boolean.FALSE,
                        () -> INITIAL_ARRAY[FIRST_ARRAY_INDEX] = (INITIAL_VALUE),
                        RuntimeException::new
            )
        );
    }

    @Test
    public void testAcceptFalse() {
        String[] value = INITIAL_ARRAY;
        Functions.acceptFalse(
                Boolean.FALSE,
                () -> value[0] = (SUCCESSFUL)
        );
        assertEquals(SUCCESSFUL, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testAcceptFalseOrElse() {
        String[] value = INITIAL_ARRAY;
        Functions.acceptFalseOrElse(
                Boolean.TRUE,
                () -> value[FIRST_ARRAY_INDEX] = (SUCCESSFUL),
                () -> value[FIRST_ARRAY_INDEX] = (SECONDARY)
        );
        assertEquals(SECONDARY, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testAcceptFalseOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.acceptFalseOrElseThrow(
                        Boolean.TRUE,
                        () -> INITIAL_ARRAY[FIRST_ARRAY_INDEX] = (INITIAL_VALUE),
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIsPresentAndEqualTo() {
        assertTrue(
                Functions.isPresentAndEqualTo(
                        SUCCESSFUL,
                        SUCCESSFUL
                )
        );
    }

    @Test
    public void testIfPresentAndEqualToDo() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndEqualToDo(
                SUCCESSFUL,
                SUCCESSFUL,
                str -> value[FIRST_ARRAY_INDEX] = str
        );
        assertEquals(SUCCESSFUL, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndEqualToDoOrElse() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndEqualToDoOrElse(
                SUCCESSFUL,
                SECONDARY,
                str -> value[FIRST_ARRAY_INDEX] = str,
                () -> value[FIRST_ARRAY_INDEX] = (SECONDARY)
        );
        assertEquals(SECONDARY, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndEqualToDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifPresentAndEqualToDoOrElseThrow(
                        SUCCESSFUL,
                        SECONDARY,
                        str -> INITIAL_ARRAY[FIRST_ARRAY_INDEX] = str,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIsPresentAndItsTrue() {
        assertTrue(
                Functions.isPresentAndItsTrue(
                        SUCCESSFUL,
                        Boolean.TRUE
                )
        );
    }

    @Test
    public void testIfPresentAndItsTrueDo() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndItsTrueDo(
                SUCCESSFUL,
                Boolean.TRUE,
                str -> value[FIRST_ARRAY_INDEX] = str
        );
        assertEquals(SUCCESSFUL, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndItsTrueDoOrElse() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndItsTrueDoOrElse(
                SUCCESSFUL,
                Boolean.FALSE,
                str -> value[FIRST_ARRAY_INDEX] = str,
                () -> value[FIRST_ARRAY_INDEX] = (SECONDARY)
        );
        assertEquals(SECONDARY, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndItsTrueDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifPresentAndItsTrueDoOrElseThrow(
                        SUCCESSFUL,
                        Boolean.FALSE,
                        str -> INITIAL_ARRAY[FIRST_ARRAY_INDEX] = str,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIsPresentAndItsFalse() {
        assertTrue(
                Functions.isPresentAndItsFalse(
                        SUCCESSFUL,
                        Boolean.FALSE
                )
        );
    }

    @Test
    public void testIfPresentAndItsFalseDo() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndItsFalseDo(
                SUCCESSFUL,
                Boolean.FALSE,
                str -> value[FIRST_ARRAY_INDEX] = str
        );
        assertEquals(SUCCESSFUL, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndItsFalseDoOrElse() {
        String[] value = INITIAL_ARRAY;
        Functions.ifPresentAndItsFalseDoOrElse(
                SUCCESSFUL,
                Boolean.TRUE,
                str -> value[FIRST_ARRAY_INDEX] = str,
                () -> value[FIRST_ARRAY_INDEX] = (SECONDARY)
        );
        assertEquals(SECONDARY, value[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfPresentAndItsFalseDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifPresentAndItsFalseDoOrElseThrow(
                        SUCCESSFUL,
                        Boolean.TRUE,
                        str -> INITIAL_ARRAY[FIRST_ARRAY_INDEX] = str,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIfNotEmptyDo() {
        List<String> value = NOT_EMPTY_LIST;
        String[] strings = INITIAL_ARRAY;
        Functions.ifNotEmptyDo(
                value,
                col -> strings[FIRST_ARRAY_INDEX] = value.get(SECOND_ARRAY_INDEX)
        );
        assertEquals(SUCCESSFUL, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfNotEmptyDoOrElse(){
        List<String> strings = new ArrayList<>();
        Functions.ifNotEmptyDoOrElse(
                EMPTY_LIST,
                col -> col.set(FIRST_ARRAY_INDEX, SECONDARY),
                () -> strings.add(SUCCESSFUL)
        );
        assertNotEquals(NOT_EMPTY_LIST.size(), strings.size());
    }

    @Test
    public void testIfNotEmptyDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifNotEmptyDoOrElseThrow(
                        EMPTY_LIST,
                        col -> col.set(FIRST_ARRAY_INDEX, SECONDARY),
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIfNotEmptyDoForEach() {
        List<String> strings = new ArrayList<>();
        Functions.ifNotEmptyDoForEach(
                NOT_EMPTY_LIST,
                strings::add
        );
        assertEquals(NOT_EMPTY_LIST.size(), strings.size());
    }

    @Test
    public void testIfNotEmptyDoForEachOrElse(){
        List<String> strings = new ArrayList<>();
        Functions.ifNotEmptyDoForEachOrElse(
                EMPTY_LIST,
                strings::add,
                () -> strings.add(INITIAL_VALUE)
        );
        assertNotEquals(NOT_EMPTY_LIST.size(), strings.size());
    }

    @Test
    public void testIfNotEmptyDoForEachOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifNotEmptyDoForEachOrElseThrow(
                        EMPTY_LIST,
                        System.out::println,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIfAllMatchDo() {
        List<String> value = NOT_EMPTY_LIST;
        String[] strings = INITIAL_ARRAY;
        Functions.ifAllMatchDo(
                value,
                PREDICATE_THAT_IS_ALWAYS_TRUE,
                col -> strings[FIRST_ARRAY_INDEX] = value.get(SECOND_ARRAY_INDEX)
        );
        assertEquals(SUCCESSFUL, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfAllMatchDoOrElse(){
        List<String> value = NOT_EMPTY_LIST;
        String[] strings = INITIAL_ARRAY;
        Functions.ifAllMatchDoOrElse(
                value,
                PREDICATE_THAT_IS_ALWAYS_FALSE,
                col -> strings[FIRST_ARRAY_INDEX] = value.get(SECOND_ARRAY_INDEX),
                () -> strings[FIRST_ARRAY_INDEX] = SECONDARY
        );
        assertEquals(SECONDARY, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfAllMatchDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifAllMatchDoOrElseThrow(
                        NOT_EMPTY_LIST,
                        PREDICATE_THAT_IS_ALWAYS_FALSE,
                        System.out::println,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIfAnyMatchDo() {
        String[] strings = INITIAL_ARRAY;
        Functions.ifAnyMatchDo(
                NOT_EMPTY_LIST,
                PREDICATE_THAT_MAY_BE_TRUE,
                col -> strings[FIRST_ARRAY_INDEX] = col.get(SECOND_ARRAY_INDEX)
        );
        assertEquals(SUCCESSFUL, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfAnyMatchDoOrElse(){
        String[] strings = INITIAL_ARRAY;
        Functions.ifAnyMatchDoOrElse(
                NOT_EMPTY_LIST,
                PREDICATE_THAT_IS_ALWAYS_FALSE,
                col -> strings[FIRST_ARRAY_INDEX] = col.get(SECOND_ARRAY_INDEX),
                () -> strings[FIRST_ARRAY_INDEX] = SECONDARY
        );
        assertEquals(SECONDARY, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfAnyMatchDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifAnyMatchDoOrElseThrow(
                        NOT_EMPTY_LIST,
                        PREDICATE_THAT_IS_ALWAYS_FALSE,
                        System.out::println,
                        RuntimeException::new
                )
        );
    }

    @Test
    public void testIfNoneMatchDo() {
        String[] strings = INITIAL_ARRAY;
        Functions.ifNoneMatchDo(
                NOT_EMPTY_LIST,
                PREDICATE_THAT_IS_ALWAYS_FALSE,
                col -> strings[FIRST_ARRAY_INDEX] = col.get(SECOND_ARRAY_INDEX)
        );
        assertEquals(SUCCESSFUL, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfNoneMatchDoOrElse(){
        String[] strings = INITIAL_ARRAY;
        Functions.ifNoneMatchDoOrElse(
                NOT_EMPTY_LIST,
                PREDICATE_THAT_MAY_BE_TRUE,
                col -> strings[FIRST_ARRAY_INDEX] = col.get(SECOND_ARRAY_INDEX),
                () -> strings[FIRST_ARRAY_INDEX] = SECONDARY
        );
        assertEquals(SECONDARY, strings[FIRST_ARRAY_INDEX]);
    }

    @Test
    public void testIfNoneMatchDoOrElseThrow() {
        assertThrows(
                RuntimeException.class,
                () -> Functions.ifNoneMatchDoOrElseThrow(
                        NOT_EMPTY_LIST,
                        PREDICATE_THAT_IS_ALWAYS_TRUE,
                        System.out::println,
                        RuntimeException::new
                )
        );
    }

}
