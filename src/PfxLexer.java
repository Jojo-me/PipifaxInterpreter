// Generated from Pfx.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PfxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DoubleLiteral=8, 
		IntLiteral=9, ID=10, WS=11, COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT", "EXP", 
			"LTR", "LTR0", "DoubleLiteral", "IntLiteral", "ID", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'var'", "'int'", "'double'", "'['", "']'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "DoubleLiteral", "IntLiteral", 
			"ID", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PfxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pfx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\ft\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007<\b\u0007\n\u0007"+
		"\f\u0007?\t\u0007\u0003\u0007A\b\u0007\u0001\b\u0001\b\u0003\bE\b\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000bP\b\u000b\u000b\u000b\f\u000bQ\u0001\u000b\u0003\u000b"+
		"U\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bZ\b\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0005\r`\b\r\n\r\f\rc\t\r\u0001\u000e\u0004"+
		"\u000ef\b\u000e\u000b\u000e\f\u000eg\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0005\u000fn\b\u000f\n\u000f\f\u000fq\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\u0000\u0011\u0000\u0013\u0000"+
		"\u0015\u0000\u0017\b\u0019\t\u001b\n\u001d\u000b\u001f\f\u0001\u0000\b"+
		"\u0001\u000019\u0001\u000009\u0002\u0000EEee\u0002\u0000++--\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\f\r  \u0002\u0000\n\n\r\rx"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001"+
		"\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000"+
		"\u0000\u0000\u0007+\u0001\u0000\u0000\u0000\t2\u0001\u0000\u0000\u0000"+
		"\u000b4\u0001\u0000\u0000\u0000\r6\u0001\u0000\u0000\u0000\u000f@\u0001"+
		"\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013H\u0001\u0000\u0000"+
		"\u0000\u0015J\u0001\u0000\u0000\u0000\u0017Y\u0001\u0000\u0000\u0000\u0019"+
		"[\u0001\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000\u001de\u0001"+
		"\u0000\u0000\u0000\u001fk\u0001\u0000\u0000\u0000!\"\u0005=\u0000\u0000"+
		"\"\u0002\u0001\u0000\u0000\u0000#$\u0005v\u0000\u0000$%\u0005a\u0000\u0000"+
		"%&\u0005r\u0000\u0000&\u0004\u0001\u0000\u0000\u0000\'(\u0005i\u0000\u0000"+
		"()\u0005n\u0000\u0000)*\u0005t\u0000\u0000*\u0006\u0001\u0000\u0000\u0000"+
		"+,\u0005d\u0000\u0000,-\u0005o\u0000\u0000-.\u0005u\u0000\u0000./\u0005"+
		"b\u0000\u0000/0\u0005l\u0000\u000001\u0005e\u0000\u00001\b\u0001\u0000"+
		"\u0000\u000023\u0005[\u0000\u00003\n\u0001\u0000\u0000\u000045\u0005]"+
		"\u0000\u00005\f\u0001\u0000\u0000\u000067\u0005+\u0000\u00007\u000e\u0001"+
		"\u0000\u0000\u00008A\u00050\u0000\u00009=\u0007\u0000\u0000\u0000:<\u0007"+
		"\u0001\u0000\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@8\u0001\u0000\u0000\u0000@9\u0001\u0000"+
		"\u0000\u0000A\u0010\u0001\u0000\u0000\u0000BD\u0007\u0002\u0000\u0000"+
		"CE\u0007\u0003\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0003\u000f\u0007\u0000G\u0012\u0001"+
		"\u0000\u0000\u0000HI\u0007\u0004\u0000\u0000I\u0014\u0001\u0000\u0000"+
		"\u0000JK\u0007\u0005\u0000\u0000K\u0016\u0001\u0000\u0000\u0000LM\u0003"+
		"\u000f\u0007\u0000MO\u0005.\u0000\u0000NP\u0007\u0001\u0000\u0000ON\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SU\u0003\u0011\b\u0000"+
		"TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UZ\u0001\u0000\u0000"+
		"\u0000VW\u0003\u000f\u0007\u0000WX\u0003\u0011\b\u0000XZ\u0001\u0000\u0000"+
		"\u0000YL\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000\u0000Z\u0018\u0001"+
		"\u0000\u0000\u0000[\\\u0003\u000f\u0007\u0000\\\u001a\u0001\u0000\u0000"+
		"\u0000]a\u0003\u0013\t\u0000^`\u0003\u0015\n\u0000_^\u0001\u0000\u0000"+
		"\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000b\u001c\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"df\u0007\u0006\u0000\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ij\u0006\u000e\u0000\u0000j\u001e\u0001\u0000\u0000\u0000"+
		"ko\u0005#\u0000\u0000ln\b\u0007\u0000\u0000ml\u0001\u0000\u0000\u0000"+
		"nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0006\u000f"+
		"\u0000\u0000s \u0001\u0000\u0000\u0000\n\u0000=@DQTYago\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}