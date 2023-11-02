import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Functions {

    public static void acceptTrue(Boolean value, EmptyAction action) {
        if (Boolean.TRUE.equals(value))
            action.run();
    }

    public static void acceptTrueOrElse(Boolean value, EmptyAction action, EmptyAction elseAction) {
        if (Boolean.TRUE.equals(value))
            action.run();
        else
            elseAction.run();
    }

    public static void acceptTrueOrElseThrow(Boolean value, EmptyAction action, Supplier<? extends Throwable> supplier) {
    public static <X extends Throwable> void acceptTrueOrElseThrow(Boolean value, EmptyAction action, Supplier<? extends X> supplier) throws X {
        if (Boolean.TRUE.equals(value))
            action.run();
        else
            throw supplier.get();
    }

    public static void acceptFalse(Boolean value, EmptyAction action) {
        if (Boolean.FALSE.equals(value))
            action.run();
    }

    public static void acceptFalseOrElse(Boolean value, EmptyAction action, EmptyAction elseAction) {
        if (Boolean.FALSE.equals(value))
            action.run();
        else
            elseAction.run();
    }

    public static <X extends Throwable> void acceptFalseOrElseThrow(Boolean value, EmptyAction action, Supplier<? extends X> supplier) throws X {
        if (Boolean.FALSE.equals(value))
            action.run();
        else
            throw supplier.get();
    }

    public static <T> Boolean isPresentAndEqualTo(T value, T toBeEqualTo) {
        return Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo);
    }

    public static <T> void ifPresentAndEqualToDo(T value, T toBeEqualTo, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
    }

    public static <T> void ifPresentAndEqualToDoOrElse(T value, T toBeEqualTo, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
        else
            action.run();
    }

    public static <T, X extends Throwable> void ifPresentAndEqualToDoOrElseThrow(T value, T toBeEqualTo, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    public static <T> Boolean isPresentAndItsTrue(T value, Boolean assertion) {
        return Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion);
    }

    public static <T> void ifPresentAndItsTrueDo(T value, Boolean assertion, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
    }

    public static <T> void ifPresentAndItsTrueDoOrElse(T value, Boolean assertion, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
        else
            action.run();
    }

    public static <T, X extends Throwable> void ifPresentAndItsTrueDoOrElseThrow(T value, Boolean assertion, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    public static <T> Boolean isPresentAndItsFalse(T value, Boolean assertion) {
        return Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion);
    }

    public static <T> void ifPresentAndItsFalseDo(T value, Boolean assertion, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
    }

    public static <T> void ifPresentAndItsFalseDoOrElse(T value, Boolean assertion, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
        else
            action.run();
    }

    public static <T, X extends Throwable> void ifPresentAndItsFalseDoOrElseThrow(T value, Boolean assertion, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    public static <T, U extends Collection<T>> void ifNotEmptyDo(U collection, Consumer<U> consumer) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
    }

    public static <T, U extends Collection<T>> void ifNotEmptyDoOrElse(U collection, Consumer<U> consumer, EmptyAction action) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
        else
            action.run();
    }

    public static <T, U extends Collection<T>, X extends Throwable> void ifNotEmptyDoOrElseThrow(U collection, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    public static <T, U extends Collection<T>> void ifNotEmptyDoForEach(U collection, Consumer<T> consumer) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
    }

    public static <T, U extends Collection<T>> void ifNotEmptyDoForEachOrElse(U collection, Consumer<T> consumer, EmptyAction action) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
        else
            action.run();
    }

    public static <T, U extends Collection<T>, X extends Throwable> void ifNotEmptyDoForEachOrElseThrow(U collection, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
        else
            throw supplier.get();
    }

    public static <T, U extends Collection<T>> void ifAllMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (collection.stream().allMatch(predicate))
            consumer.accept(collection);
    }

    public static <T, U extends Collection<T>> void ifAllMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (collection.stream().allMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    public static <T, U extends Collection<T>, X extends Throwable> void ifAllMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (collection.stream().allMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    public static <T, U extends Collection<T>> void ifAnyMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (collection.stream().anyMatch(predicate))
            consumer.accept(collection);
    }

    public static <T, U extends Collection<T>> void ifAnyMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (collection.stream().anyMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    public static <T, U extends Collection<T>, X extends Throwable> void ifAnyMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (collection.stream().anyMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    public static <T, U extends Collection<T>> void ifNoneMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (collection.stream().noneMatch(predicate))
            consumer.accept(collection);
    }

    public static <T, U extends Collection<T>> void ifNoneMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (collection.stream().noneMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    public static <T, U extends Collection<T>, X extends Throwable> void ifNoneMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (collection.stream().noneMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

}
