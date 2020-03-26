package team.easytravel.logic.parser.activity;

import java.util.Arrays;

import team.easytravel.commons.core.Messages;
import team.easytravel.logic.commands.activity.FindActivityCommand;
import team.easytravel.logic.parser.Parser;
import team.easytravel.logic.parser.exceptions.ParseException;
import team.easytravel.model.listmanagers.activity.ActivityContainKeywordPredicate;

/**
 * Finds and lists all activities whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindActivityCommandParser implements Parser<FindActivityCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindActivityCommand
     * and returns a FindActivityCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindActivityCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, FindActivityCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindActivityCommand(new ActivityContainKeywordPredicate(Arrays.asList(nameKeywords)));
    }
}
