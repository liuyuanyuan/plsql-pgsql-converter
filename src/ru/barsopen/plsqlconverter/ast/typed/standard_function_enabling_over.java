package ru.barsopen.plsqlconverter.ast.typed;
public class standard_function_enabling_over implements standard_function, _baseNode {
  public int _line = -1;
  public int _col = -1;
  public int _tokenStartIndex = -1;
  public int _tokenStopIndex = -1;
  public _baseNode _parent = null;
  public _baseNode _getParent() { return _parent; }
  public void _setParent(_baseNode value) { _parent = value; }
  public void _setBaseNode(_baseNode value) { this._parent = value; }
  public int _getLine() { return _line; }
  public int _getCol() { return _col; }
  public int _getTokenStartIndex() { return _tokenStartIndex; }
  public int _getTokenStopIndex() { return _tokenStopIndex; }
ru.barsopen.plsqlconverter.util.AttachedComments _comments;
public void setComments(ru.barsopen.plsqlconverter.util.AttachedComments comments) { this._comments = comments; }
public ru.barsopen.plsqlconverter.util.AttachedComments getAttachedComments() { return this._comments; }
public void _setCol(int col) { this._col = col; }
public void _setLine(int line) { this._line = line; }

  public String name = null;
  public String get_name() { return this.name; }
  public void set_name(String value) {
    this.name = value;
  }
  public function_argument function_argument = null;
  public function_argument get_function_argument() { return this.function_argument; }
  public void set_function_argument(function_argument value) {
    if (this.function_argument != null) { this.function_argument._setParent(null); }
    this.function_argument = value;
    if (this.function_argument != null) { this.function_argument._setParent(this); }
  }
  public over_clause over_clause = null;
  public over_clause get_over_clause() { return this.over_clause; }
  public void set_over_clause(over_clause value) {
    if (this.over_clause != null) { this.over_clause._setParent(null); }
    this.over_clause = value;
    if (this.over_clause != null) { this.over_clause._setParent(this); }
  }
  public boolean is_over_clause() { return this.over_clause != null; }

  public void _walk(_visitor visitor) {
    if (!visitor.enter(this)) {
      return;
    }
    if (this.function_argument != null) {
      this.function_argument._walk(visitor);
    }
    if (this.over_clause != null) {
      this.over_clause._walk(visitor);
    }
    visitor.leave(this);
  }

  public java.util.List<_baseNode> _getChildren() {
    java.util.List<_baseNode> result = new java.util.ArrayList<_baseNode>();
    if (this.function_argument != null) {
      result.add(this.function_argument);
    }
    if (this.over_clause != null) {
      result.add(this.over_clause);
    }
    return result;
  }

  public void _replace(_baseNode child, _baseNode replacement) {
    if (this.function_argument == child) {
      this.set_function_argument((ru.barsopen.plsqlconverter.ast.typed.function_argument)replacement);
      return;
    }
    if (this.over_clause == child) {
      this.set_over_clause((ru.barsopen.plsqlconverter.ast.typed.over_clause)replacement);
      return;
    }
    throw new RuntimeException("Failed to replace node: no such node");
  }

  public org.antlr.runtime.tree.Tree unparse() {
    org.antlr.runtime.CommonToken _token = new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.FUNCTION_ENABLING_OVER);
    _token.setLine(_line);
    _token.setCharPositionInLine(_col);
    _token.setText(name);
    org.antlr.runtime.tree.CommonTree _result = new org.antlr.runtime.tree.CommonTree(_token);

if (_comments != null) {
  org.antlr.runtime.tree.CommonTree commentsNode = new org.antlr.runtime.tree.CommonTree(
    new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.COMMENT));
  org.antlr.runtime.tree.CommonTree commentsBeforeNode = new org.antlr.runtime.tree.CommonTree(
    new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.COMMENT, _comments.getBefore()));
  org.antlr.runtime.tree.CommonTree commentsAfterNode = new org.antlr.runtime.tree.CommonTree(
    new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.COMMENT, _comments.getAfter()));
  org.antlr.runtime.tree.CommonTree commentsInsideNode = new org.antlr.runtime.tree.CommonTree(
    new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.COMMENT, _comments.getInside()));
  commentsNode.addChild(commentsBeforeNode);
  commentsNode.addChild(commentsInsideNode);
  commentsNode.addChild(commentsAfterNode);
  _result.addChild(commentsNode);
}

    _result.setTokenStartIndex(_tokenStartIndex);
    _result.setTokenStopIndex(_tokenStopIndex);

    if (function_argument == null) { throw new RuntimeException(); }
    _result.addChild(function_argument.unparse());


    if (over_clause != null) {
      _result.addChild(over_clause.unparse());
    }


    return _result;
  }

}
