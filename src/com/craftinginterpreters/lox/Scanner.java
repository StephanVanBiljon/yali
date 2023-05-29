package com.craftinginterpreters.lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.craftinginterpreters.lox.TokenType.*;
class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    // First character in the lexeme being scanned.
    private int start = 0;

    // Character currently being considered.
    private int current = 0;
    private int line = 1;

    Scanner(String source) {
        this.source = source;
    }

    /**
     * Adds tokens until the scanner runs out of characters.
     * @return
     */
    List<Token> scanTokens() {
        while(!isAtEnd()) {
            // We are at the beginning of the next lexeme.
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }
}
