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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, DoubleLiteral=6, IntLiteral=7, 
		ID=8, WS=9, COMMENT=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "INT", "EXP", "LTR", "LTR0", 
			"DoubleLiteral", "IntLiteral", "ID", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'var'", "'int'", "'double'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "DoubleLiteral", "IntLiteral", "ID", 
			"WS", "COMMENT"
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
		"\u0004\u0000\nl\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u00054\b\u0005\n\u0005\f\u00057\t\u0005\u0003"+
		"\u00059\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006=\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0004\tH\b\t\u000b\t\f\tI\u0001\t\u0003\tM\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\tR\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000bX\b"+
		"\u000b\n\u000b\f\u000b[\t\u000b\u0001\f\u0004\f^\b\f\u000b\f\f\f_\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0005\rf\b\r\n\r\f\ri\t\r\u0001\r\u0001\r\u0000"+
		"\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0000\r\u0000\u000f\u0000\u0011\u0000\u0013\u0006\u0015\u0007\u0017\b"+
		"\u0019\t\u001b\n\u0001\u0000\b\u0001\u000019\u0001\u000009\u0002\u0000"+
		"EEee\u0002\u0000++--\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000"+
		"\t\n\f\r  \u0002\u0000\n\n\r\rp\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003\u001f"+
		"\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007\'\u0001"+
		"\u0000\u0000\u0000\t.\u0001\u0000\u0000\u0000\u000b8\u0001\u0000\u0000"+
		"\u0000\r:\u0001\u0000\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011"+
		"B\u0001\u0000\u0000\u0000\u0013Q\u0001\u0000\u0000\u0000\u0015S\u0001"+
		"\u0000\u0000\u0000\u0017U\u0001\u0000\u0000\u0000\u0019]\u0001\u0000\u0000"+
		"\u0000\u001bc\u0001\u0000\u0000\u0000\u001d\u001e\u0005=\u0000\u0000\u001e"+
		"\u0002\u0001\u0000\u0000\u0000\u001f \u0005v\u0000\u0000 !\u0005a\u0000"+
		"\u0000!\"\u0005r\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005i"+
		"\u0000\u0000$%\u0005n\u0000\u0000%&\u0005t\u0000\u0000&\u0006\u0001\u0000"+
		"\u0000\u0000\'(\u0005d\u0000\u0000()\u0005o\u0000\u0000)*\u0005u\u0000"+
		"\u0000*+\u0005b\u0000\u0000+,\u0005l\u0000\u0000,-\u0005e\u0000\u0000"+
		"-\b\u0001\u0000\u0000\u0000./\u0005+\u0000\u0000/\n\u0001\u0000\u0000"+
		"\u000009\u00050\u0000\u000015\u0007\u0000\u0000\u000024\u0007\u0001\u0000"+
		"\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000080\u0001\u0000\u0000\u000081\u0001\u0000\u0000\u0000"+
		"9\f\u0001\u0000\u0000\u0000:<\u0007\u0002\u0000\u0000;=\u0007\u0003\u0000"+
		"\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000>?\u0003\u000b\u0005\u0000?\u000e\u0001\u0000\u0000\u0000"+
		"@A\u0007\u0004\u0000\u0000A\u0010\u0001\u0000\u0000\u0000BC\u0007\u0005"+
		"\u0000\u0000C\u0012\u0001\u0000\u0000\u0000DE\u0003\u000b\u0005\u0000"+
		"EG\u0005.\u0000\u0000FH\u0007\u0001\u0000\u0000GF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JL\u0001\u0000\u0000\u0000KM\u0003\r\u0006\u0000LK\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MR\u0001\u0000\u0000\u0000NO\u0003\u000b"+
		"\u0005\u0000OP\u0003\r\u0006\u0000PR\u0001\u0000\u0000\u0000QD\u0001\u0000"+
		"\u0000\u0000QN\u0001\u0000\u0000\u0000R\u0014\u0001\u0000\u0000\u0000"+
		"ST\u0003\u000b\u0005\u0000T\u0016\u0001\u0000\u0000\u0000UY\u0003\u000f"+
		"\u0007\u0000VX\u0003\u0011\b\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0018"+
		"\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\^\u0007\u0006\u0000"+
		"\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0006"+
		"\f\u0000\u0000b\u001a\u0001\u0000\u0000\u0000cg\u0005#\u0000\u0000df\b"+
		"\u0007\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000jk\u0006\r\u0000\u0000k\u001c\u0001\u0000"+
		"\u0000\u0000\n\u000058<ILQY_g\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}