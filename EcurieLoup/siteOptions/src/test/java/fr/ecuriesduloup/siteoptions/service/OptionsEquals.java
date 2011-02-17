package fr.ecuriesduloup.siteoptions.service;
import org.easymock.IArgumentMatcher;

import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionsEquals implements IArgumentMatcher {
    private Option expected;

    public OptionsEquals(Option expected) {
        this.expected = expected;
    }

    public boolean matches(Object actual) {
        if (!(actual instanceof Option)) {
            return false;
        }
        Option option = (Option)actual;
        return option.getName().equals(expected.getName())  && option.getValue().equals(expected.getValue()) && option.getUser().equals(expected.getUser());
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("true(");

    }
}