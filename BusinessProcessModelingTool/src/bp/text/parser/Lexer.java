package bp.text.parser;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final TokenFactory tokenFactory;

    private LexerState state;
    private final StringBuilder in;
    private final StringBuilder processed;
    private final List<Token> tokens;

    public Lexer() {
        this.tokenFactory = new TokenFactory();
        this.in = new StringBuilder();
        this.processed = new StringBuilder();
        this.tokens = new ArrayList<>();
    }

    public Token[] buildTokens(final String input) {
        clearStringBuilder(this.in);
        clearStringBuilder(this.processed);
        this.tokens.clear();

        toUnknownState();

        while (this.in.length() > 0) {
            final char c = this.in.charAt(0);

            switch (this.state) {
            case TEXT_STATE:
                if (isText(c) || isDigit(c)) {
                    this.processed.append(c);
                } else {
                    // TODO: check for keywords
                    this.tokens.add(this.tokenFactory.createIdentifierToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    if (isWhitespace(c)) {
                        toWhitespaceState();
                    } else if (isDoubleQuote(c)) {
                        toStringState();
                    } else {
                        if (isOpenedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createOpenedCurvyBracketToken());
                        } else if (isClosedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createClosedCurvyBracketToken());
                        } else if (isAssignemt(c)) {
                            this.tokens.add(this.tokenFactory.createAssignmentToken());
                        }
                        toUnknownState();
                    }
                }
                break;
            case NUMBER_STATE:
                if (isDigit(c)) {
                    this.processed.append(c);
                } else {
                    this.tokens.add(this.tokenFactory.createNumberToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    if (isWhitespace(c)) {
                        toWhitespaceState();
                    } else if (isText(c)) {
                        toTextState();
                    } else if (isDoubleQuote(c)) {
                        toStringState();
                    } else {
                        if (isOpenedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createOpenedCurvyBracketToken());
                        } else if (isClosedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createClosedCurvyBracketToken());
                        } else if (isAssignemt(c)) {
                            this.tokens.add(this.tokenFactory.createAssignmentToken());
                        }
                        toUnknownState();
                    }
                }
                break;
            case STRING_STATE:
                this.processed.append(c);
                if (isDoubleQuote(c)) {
                    this.tokens.add(this.tokenFactory.createStringToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    toUnknownState();
                }
                break;
            case LINE_COMMENT_STATE:
                this.processed.append(c);
                if (c == '\n') {
                    this.tokens.add(this.tokenFactory.createLineCommentToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    toUnknownState();
                }
                break;
            case COMMENT_STATE:
                this.processed.append(c);
                if (isSlash(c) && isStar(this.processed.charAt(this.processed.length() - 1))) {
                    this.tokens.add(this.tokenFactory.createCommentToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    toUnknownState();
                }
                break;
            case WHITESPACE_STATE:
                if (isWhitespace(c)) {
                    this.processed.append(c);
                } else {
                    this.tokens.add(this.tokenFactory.createWhitespaceToken(this.processed.toString()));
                    clearStringBuilder(this.processed);
                    if (isDigit(c)) {
                        toNumberState();
                    } else if (isText(c)) {
                        toTextState();
                    } else if (isDoubleQuote(c)) {
                        toStringState();
                    } else {
                        if (isOpenedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createOpenedCurvyBracketToken());
                        } else if (isClosedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createClosedCurvyBracketToken());
                        } else if (isAssignemt(c)) {
                            this.tokens.add(this.tokenFactory.createAssignmentToken());
                        }
                        toUnknownState();
                    }
                }
                break;
            case UNKNOWN_STATE:
                if (this.processed.length() == 0) {
                    if (isText(c)) {
                        this.processed.append(c);
                        toTextState();
                    } else if (isDigit(c)) {
                        this.processed.append(c);
                        toNumberState();
                    } else if (isWhitespace(c)) {
                        this.processed.append(c);
                        toWhitespaceState();
                    } else if (isDoubleQuote(c)) {
                        this.processed.append(c);
                        toStringState();
                    } else {
                        if (isOpenedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createOpenedCurvyBracketToken());
                        } else if (isClosedCurvyBracket(c)) {
                            this.tokens.add(this.tokenFactory.createClosedCurvyBracketToken());
                        } else if (isAssignemt(c)) {
                            this.tokens.add(this.tokenFactory.createAssignmentToken());
                        } else {
                            this.processed.append(c);
                        }
                    }
                } else {
                    if (isWhitespace(c)) {
                        this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.toString()));
                        clearStringBuilder(this.processed);
                        this.processed.append(c);
                        toWhitespaceState();
                    } else if (isDoubleQuote(c)) {
                        this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.toString()));
                        clearStringBuilder(this.processed);
                        this.processed.append(c);
                        toStringState();
                    } else {
                        this.processed.append(c);
                        if (isSlash(c)) {
                            if (isSlash(this.processed.charAt(this.processed.length() - 2))) {
                                if (this.processed.length() > 2) {
                                    this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.substring(0,
                                            this.processed.length() - 2)));
                                    this.processed.delete(0, this.processed.length() - 2);
                                }
                                toLineCommentState();
                            }
                        } else if (isStar(c)) {
                            if (isSlash(this.processed.charAt(this.processed.length() - 2))) {
                                if (this.processed.length() > 2) {
                                    this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.substring(0,
                                            this.processed.length() - 2)));
                                    this.processed.delete(0, this.processed.length() - 2);
                                }
                                toCommentState();
                            }
                        }
                    }
                }
                break;
            }
            this.in.deleteCharAt(0);
        }

        if (this.processed.length() > 0) {
            if (this.state == LexerState.TEXT_STATE) {
                this.tokens.add(this.tokenFactory.createIdentifierToken(this.processed.toString()));
            } else if (this.state == LexerState.NUMBER_STATE) {
                this.tokens.add(this.tokenFactory.createNumberToken(this.processed.toString()));
            } else if (this.state == LexerState.STRING_STATE) {
                this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.toString()));
            } else if (this.state == LexerState.LINE_COMMENT_STATE) {
                this.tokens.add(this.tokenFactory.createLineCommentToken(this.processed.toString()));
            } else if (this.state == LexerState.COMMENT_STATE) {
                this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.toString()));
            } else if (this.state == LexerState.WHITESPACE_STATE) {
                this.tokens.add(this.tokenFactory.createWhitespaceToken(this.processed.toString()));
            } else if (this.state == LexerState.UNKNOWN_STATE) {
                this.tokens.add(this.tokenFactory.createUnknownToken(this.processed.toString()));
            }
        }

        return this.tokens.toArray(new Token[this.tokens.size()]);
    }

    private void clearStringBuilder(final StringBuilder sb) {
        sb.delete(0, sb.length());
    }

    private void toTextState() {
        this.state = LexerState.TEXT_STATE;
    }

    private void toNumberState() {
        this.state = LexerState.NUMBER_STATE;
    }

    private void toStringState() {
        this.state = LexerState.STRING_STATE;
    }

    private void toLineCommentState() {
        this.state = LexerState.LINE_COMMENT_STATE;
    }

    private void toCommentState() {
        this.state = LexerState.COMMENT_STATE;
    }

    private void toWhitespaceState() {
        this.state = LexerState.WHITESPACE_STATE;
    }

    private void toUnknownState() {
        this.state = LexerState.UNKNOWN_STATE;
    }

    private boolean isWhitespace(final char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r';
    }

    private boolean isLetter(final char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isUnderscore(final char c) {
        return c == '_';
    }

    private boolean isText(final char c) {
        return isLetter(c) || isUnderscore(c);
    }

    private boolean isDigit(final char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isDoubleQuote(final char c) {
        return c == '"';
    }

    private boolean isOpenedCurvyBracket(final char c) {
        return c == '{';
    }

    private boolean isClosedCurvyBracket(final char c) {
        return c == '}';
    }

    private boolean isAssignemt(final char c) {
        return c == ':';
    }

    private boolean isSlash(final char c) {
        return c == '/';
    }

    private boolean isStar(final char c) {
        return c == '*';
    }
}
