package com.dibs.graphql.deserialize.parser;

import java.util.Set;

import com.dibs.graphql.data.deserialize.TokenData;
import com.dibs.graphql.data.deserialize.TokenType;
import com.dibs.graphql.util.Util;

public class TokenUtil {

	public static final Set<TokenType> FILTER_KEY_TERMINATORS = Util.newHashSet(TokenType.ATTRIBUTE_DELIM);
	public static final Set<TokenType> FILTER_VALUE_TERMINATORS = Util.newHashSet(TokenType.ATTRIBUTE_END, TokenType.ATTRIBUTE_END);
	public static final Set<TokenType> TOKEN_VALUE_TERMINATORS = Util.newHashSet(TokenType.ATTRIBUTE_START, TokenType.OBJECT_DELIM, TokenType.OBJECT_START, TokenType.OBJECT_END);

	public static boolean isAttributeTerminator(TokenData token) {
		return token != null && token.getType() == TokenType.ATTRIBUTE_END;
	}	
	
	public static boolean isAttributeStart(TokenData token) {
		TokenType tokenType = token.getType();
		
		return tokenType == TokenType.ATTRIBUTE_START;
	}
	
	public static boolean isTokenTerminator(TokenData token) {
		if (token == null) {
			return false;
		}
		TokenType tokenType = token.getType();

		return tokenType == TokenType.OBJECT_START 
						|| tokenType == TokenType.OBJECT_DELIM 
						|| tokenType == TokenType.OBJECT_END;
	}
}
