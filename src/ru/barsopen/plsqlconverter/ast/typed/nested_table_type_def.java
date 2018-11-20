package ru.barsopen.plsqlconverter.ast.typed;
public class nested_table_type_def implements object_as_part_def, _baseNode {
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

  public type_spec type_spec = null;
  public type_spec get_type_spec() { return this.type_spec; }
  public void set_type_spec(type_spec value) {
    if (this.type_spec != null) { this.type_spec._setParent(null); }
    this.type_spec = value;
    if (this.type_spec != null) { this.type_spec._setParent(this); }
  }
  public org.antlr.runtime.tree.Tree SQL92_RESERVED_NULL = null;
  public org.antlr.runtime.tree.Tree get_SQL92_RESERVED_NULL() { return this.SQL92_RESERVED_NULL; }
  public void set_SQL92_RESERVED_NULL(org.antlr.runtime.tree.Tree value) {
    this.SQL92_RESERVED_NULL = value;
  }
  public boolean is_SQL92_RESERVED_NULL() { return this.SQL92_RESERVED_NULL != null; }
  public table_indexed_by_part table_indexed_by_part = null;
  public table_indexed_by_part get_table_indexed_by_part() { return this.table_indexed_by_part; }
  public void set_table_indexed_by_part(table_indexed_by_part value) {
    if (this.table_indexed_by_part != null) { this.table_indexed_by_part._setParent(null); }
    this.table_indexed_by_part = value;
    if (this.table_indexed_by_part != null) { this.table_indexed_by_part._setParent(this); }
  }
  public boolean is_table_indexed_by_part() { return this.table_indexed_by_part != null; }

  public void _walk(_visitor visitor) {
    if (!visitor.enter(this)) {
      return;
    }
    if (this.type_spec != null) {
      this.type_spec._walk(visitor);
    }
    if (this.SQL92_RESERVED_NULL != null) {
      visitor.visit(this.SQL92_RESERVED_NULL);
    }
    if (this.table_indexed_by_part != null) {
      this.table_indexed_by_part._walk(visitor);
    }
    visitor.leave(this);
  }

  public java.util.List<_baseNode> _getChildren() {
    java.util.List<_baseNode> result = new java.util.ArrayList<_baseNode>();
    if (this.type_spec != null) {
      result.add(this.type_spec);
    }
    if (this.table_indexed_by_part != null) {
      result.add(this.table_indexed_by_part);
    }
    return result;
  }

  public void _replace(_baseNode child, _baseNode replacement) {
    if (this.type_spec == child) {
      this.set_type_spec((ru.barsopen.plsqlconverter.ast.typed.type_spec)replacement);
      return;
    }
    if (this.table_indexed_by_part == child) {
      this.set_table_indexed_by_part((ru.barsopen.plsqlconverter.ast.typed.table_indexed_by_part)replacement);
      return;
    }
    throw new RuntimeException("Failed to replace node: no such node");
  }

  public org.antlr.runtime.tree.Tree unparse() {
    org.antlr.runtime.CommonToken _token = new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.NESTED_TABLE_TYPE_DEF);
    _token.setLine(_line);
    _token.setCharPositionInLine(_col);
    _token.setText("NESTED_TABLE_TYPE_DEF");
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
    if (type_spec == null) { throw new RuntimeException(); }
    _result.addChild(type_spec.unparse());


    if (SQL92_RESERVED_NULL != null) {
      _result.addChild(SQL92_RESERVED_NULL);
    }


    if (table_indexed_by_part != null) {
      _result.addChild(table_indexed_by_part.unparse());
    }


    return _result;
  }

}
