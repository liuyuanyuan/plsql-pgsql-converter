package ru.barsopen.plsqlconverter.ast.typed;
public class expression_element_neq implements expression_element, _baseNode {
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

  public expression_element lhs = null;
  public expression_element get_lhs() { return this.lhs; }
  public void set_lhs(expression_element value) {
    if (this.lhs != null) { this.lhs._setParent(null); }
    this.lhs = value;
    if (this.lhs != null) { this.lhs._setParent(this); }
  }
  public expression_element rhs = null;
  public expression_element get_rhs() { return this.rhs; }
  public void set_rhs(expression_element value) {
    if (this.rhs != null) { this.rhs._setParent(null); }
    this.rhs = value;
    if (this.rhs != null) { this.rhs._setParent(this); }
  }

  public void _walk(_visitor visitor) {
    if (!visitor.enter(this)) {
      return;
    }
    if (this.lhs != null) {
      this.lhs._walk(visitor);
    }
    if (this.rhs != null) {
      this.rhs._walk(visitor);
    }
    visitor.leave(this);
  }

  public java.util.List<_baseNode> _getChildren() {
    java.util.List<_baseNode> result = new java.util.ArrayList<_baseNode>();
    if (this.lhs != null) {
      result.add(this.lhs);
    }
    if (this.rhs != null) {
      result.add(this.rhs);
    }
    return result;
  }

  public void _replace(_baseNode child, _baseNode replacement) {
    if (this.lhs == child) {
      this.set_lhs((ru.barsopen.plsqlconverter.ast.typed.expression_element)replacement);
      return;
    }
    if (this.rhs == child) {
      this.set_rhs((ru.barsopen.plsqlconverter.ast.typed.expression_element)replacement);
      return;
    }
    throw new RuntimeException("Failed to replace node: no such node");
  }

  public org.antlr.runtime.tree.Tree unparse() {
    org.antlr.runtime.CommonToken _token = new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.NOT_EQUAL_OP);
    _token.setLine(_line);
    _token.setCharPositionInLine(_col);
    _token.setText("NOT_EQUAL_OP");
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
    if (lhs == null) { throw new RuntimeException(); }
    _result.addChild(lhs.unparse());


    if (rhs == null) { throw new RuntimeException(); }
    _result.addChild(rhs.unparse());


    return _result;
  }

}
