package ru.barsopen.plsqlconverter.ast.typed;
public class seq_of_statements implements expression_or_seq_of_statements, _baseNode {
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

  public java.util.List<stat_or_label> stat_or_labels = new java.util.ArrayList<stat_or_label>();
  public java.util.List<stat_or_label> get_stat_or_labels() { return this.stat_or_labels; }
  public void add_stat_or_labels(stat_or_label value) {
    insert_stat_or_labels(stat_or_labels.size(), value);
  }
  public void insert_stat_or_labels(int pos, stat_or_label value) {
    this.stat_or_labels.add(pos, value);
    value._setParent(this);
  }
  public void remove_stat_or_labels(int pos) {
    this.stat_or_labels.get(pos)._setParent(null);
    this.stat_or_labels.remove(pos);
  }
  public void remove_stat_or_labels(stat_or_label value) {
    this.remove_stat_or_labels(this.stat_or_labels.indexOf(value));
  }

  public void _walk(_visitor visitor) {
    if (!visitor.enter(this)) {
      return;
    }
    for (stat_or_label _value: this.stat_or_labels) {
      _value._walk(visitor);
    }
    visitor.leave(this);
  }

  public java.util.List<_baseNode> _getChildren() {
    java.util.List<_baseNode> result = new java.util.ArrayList<_baseNode>();
    result.addAll(this.stat_or_labels);
    return result;
  }

  public void _replace(_baseNode child, _baseNode replacement) {
    for (int _i = 0; _i < this.stat_or_labels.size(); ++_i) {
      if (this.stat_or_labels.get(_i) == child) {
        this.remove_stat_or_labels(_i);
        this.insert_stat_or_labels(_i, (ru.barsopen.plsqlconverter.ast.typed.stat_or_label)replacement);
        return;
      }
    }
    throw new RuntimeException("Failed to replace node: no such node");
  }

  public org.antlr.runtime.tree.Tree unparse() {
    org.antlr.runtime.CommonToken _token = new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.STATEMENTS);
    _token.setLine(_line);
    _token.setCharPositionInLine(_col);
    _token.setText("STATEMENTS");
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
    if (stat_or_labels.size() == 0) { throw new RuntimeException(); }
    for (int i = 0; i < stat_or_labels.size(); ++i) {
      _result.addChild(stat_or_labels.get(i).unparse());
    }


    return _result;
  }

}
