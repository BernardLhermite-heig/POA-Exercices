package unit3;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ExB {
    public Set<String> firstShortStrings(Collection<String> strings,
                                         int n, int maxLength) {
        return strings.stream()
                .filter(w -> w.length() <= maxLength)
                .limit(n)
                .collect(Collectors.toSet());
    }
}