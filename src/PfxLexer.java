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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, DoubleLiteral=13, IntLiteral=14, ID=15, WS=16, 
		COMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "INT", "EXP", "LTR", "LTR0", "DoubleLiteral", 
			"IntLiteral", "ID", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'('", "')'", "'{'", "'}'", "'='", "'var'", "'int'", 
			"'double'", "'['", "']'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "DoubleLiteral", "IntLiteral", "ID", "WS", "COMMENT"
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
		"\u0004\u0000\u0011\u008b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\fS\b\f\n\f\f"+
		"\fV\t\f\u0003\fX\b\f\u0001\r\u0001\r\u0003\r\\\b\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0004\u0010g\b\u0010\u000b\u0010\f\u0010h\u0001\u0010\u0003\u0010"+
		"l\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010q\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012w\b\u0012\n\u0012"+
		"\f\u0012z\t\u0012\u0001\u0013\u0004\u0013}\b\u0013\u000b\u0013\f\u0013"+
		"~\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u0085\b"+
		"\u0014\n\u0014\f\u0014\u0088\t\u0014\u0001\u0014\u0001\u0014\u0000\u0000"+
		"\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\u0000\u001b"+
		"\u0000\u001d\u0000\u001f\u0000!\r#\u000e%\u000f\'\u0010)\u0011\u0001\u0000"+
		"\b\u0001\u000019\u0001\u000009\u0002\u0000EEee\u0002\u0000++--\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\f\r  \u0002\u0000\n\n\r\r\u008f"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0001+\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u00052"+
		"\u0001\u0000\u0000\u0000\u00074\u0001\u0000\u0000\u0000\t6\u0001\u0000"+
		"\u0000\u0000\u000b8\u0001\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000"+
		"\u000f>\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013I"+
		"\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017M\u0001\u0000"+
		"\u0000\u0000\u0019W\u0001\u0000\u0000\u0000\u001bY\u0001\u0000\u0000\u0000"+
		"\u001d_\u0001\u0000\u0000\u0000\u001fa\u0001\u0000\u0000\u0000!p\u0001"+
		"\u0000\u0000\u0000#r\u0001\u0000\u0000\u0000%t\u0001\u0000\u0000\u0000"+
		"\'|\u0001\u0000\u0000\u0000)\u0082\u0001\u0000\u0000\u0000+,\u0005f\u0000"+
		"\u0000,-\u0005u\u0000\u0000-.\u0005n\u0000\u0000./\u0005c\u0000\u0000"+
		"/\u0002\u0001\u0000\u0000\u000001\u0005(\u0000\u00001\u0004\u0001\u0000"+
		"\u0000\u000023\u0005)\u0000\u00003\u0006\u0001\u0000\u0000\u000045\u0005"+
		"{\u0000\u00005\b\u0001\u0000\u0000\u000067\u0005}\u0000\u00007\n\u0001"+
		"\u0000\u0000\u000089\u0005=\u0000\u00009\f\u0001\u0000\u0000\u0000:;\u0005"+
		"v\u0000\u0000;<\u0005a\u0000\u0000<=\u0005r\u0000\u0000=\u000e\u0001\u0000"+
		"\u0000\u0000>?\u0005i\u0000\u0000?@\u0005n\u0000\u0000@A\u0005t\u0000"+
		"\u0000A\u0010\u0001\u0000\u0000\u0000BC\u0005d\u0000\u0000CD\u0005o\u0000"+
		"\u0000DE\u0005u\u0000\u0000EF\u0005b\u0000\u0000FG\u0005l\u0000\u0000"+
		"GH\u0005e\u0000\u0000H\u0012\u0001\u0000\u0000\u0000IJ\u0005[\u0000\u0000"+
		"J\u0014\u0001\u0000\u0000\u0000KL\u0005]\u0000\u0000L\u0016\u0001\u0000"+
		"\u0000\u0000MN\u0005+\u0000\u0000N\u0018\u0001\u0000\u0000\u0000OX\u0005"+
		"0\u0000\u0000PT\u0007\u0000\u0000\u0000QS\u0007\u0001\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000WO\u0001\u0000\u0000\u0000WP\u0001\u0000\u0000\u0000X\u001a\u0001"+
		"\u0000\u0000\u0000Y[\u0007\u0002\u0000\u0000Z\\\u0007\u0003\u0000\u0000"+
		"[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]^\u0003\u0019\f\u0000^\u001c\u0001\u0000\u0000\u0000_`\u0007\u0004"+
		"\u0000\u0000`\u001e\u0001\u0000\u0000\u0000ab\u0007\u0005\u0000\u0000"+
		"b \u0001\u0000\u0000\u0000cd\u0003\u0019\f\u0000df\u0005.\u0000\u0000"+
		"eg\u0007\u0001\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000jl\u0003\u001b\r\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lq\u0001\u0000\u0000\u0000mn\u0003\u0019\f\u0000no\u0003\u001b"+
		"\r\u0000oq\u0001\u0000\u0000\u0000pc\u0001\u0000\u0000\u0000pm\u0001\u0000"+
		"\u0000\u0000q\"\u0001\u0000\u0000\u0000rs\u0003\u0019\f\u0000s$\u0001"+
		"\u0000\u0000\u0000tx\u0003\u001d\u000e\u0000uw\u0003\u001f\u000f\u0000"+
		"vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y&\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000{}\u0007\u0006\u0000\u0000|{\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0013\u0000"+
		"\u0000\u0081(\u0001\u0000\u0000\u0000\u0082\u0086\u0005#\u0000\u0000\u0083"+
		"\u0085\b\u0007\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0006\u0014\u0000\u0000\u008a*\u0001"+
		"\u0000\u0000\u0000\n\u0000TW[hkpx~\u0086\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}