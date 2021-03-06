package ru.barsopen.plsqlconverter.ast.typed;
public class create_procedure_body implements create_function_or_procedure_body, _baseNode {
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

  public org.antlr.runtime.tree.Tree SQL92_RESERVED_CREATE = null;
  public org.antlr.runtime.tree.Tree get_SQL92_RESERVED_CREATE() { return this.SQL92_RESERVED_CREATE; }
  public void set_SQL92_RESERVED_CREATE(org.antlr.runtime.tree.Tree value) {
    this.SQL92_RESERVED_CREATE = value;
  }
  public boolean is_SQL92_RESERVED_CREATE() { return this.SQL92_RESERVED_CREATE != null; }
  public org.antlr.runtime.tree.Tree REPLACE_VK = null;
  public org.antlr.runtime.tree.Tree get_REPLACE_VK() { return this.REPLACE_VK; }
  public void set_REPLACE_VK(org.antlr.runtime.tree.Tree value) {
    this.REPLACE_VK = value;
  }
  public boolean is_REPLACE_VK() { return this.REPLACE_VK != null; }
  public procedure_name procedure_name = null;
  public procedure_name get_procedure_name() { return this.procedure_name; }
  public void set_procedure_name(procedure_name value) {
    if (this.procedure_name != null) { this.procedure_name._setParent(null); }
    this.procedure_name = value;
    if (this.procedure_name != null) { this.procedure_name._setParent(this); }
  }
  public parameters parameters = null;
  public parameters get_parameters() { return this.parameters; }
  public void set_parameters(parameters value) {
    if (this.parameters != null) { this.parameters._setParent(null); }
    this.parameters = value;
    if (this.parameters != null) { this.parameters._setParent(this); }
  }
  public invoker_rights_clause invoker_rights_clause = null;
  public invoker_rights_clause get_invoker_rights_clause() { return this.invoker_rights_clause; }
  public void set_invoker_rights_clause(invoker_rights_clause value) {
    if (this.invoker_rights_clause != null) { this.invoker_rights_clause._setParent(null); }
    this.invoker_rights_clause = value;
    if (this.invoker_rights_clause != null) { this.invoker_rights_clause._setParent(this); }
  }
  public boolean is_invoker_rights_clause() { return this.invoker_rights_clause != null; }
  public create_procedure_body_impl create_procedure_body_impl = null;
  public create_procedure_body_impl get_create_procedure_body_impl() { return this.create_procedure_body_impl; }
  public void set_create_procedure_body_impl(create_procedure_body_impl value) {
    if (this.create_procedure_body_impl != null) { this.create_procedure_body_impl._setParent(null); }
    this.create_procedure_body_impl = value;
    if (this.create_procedure_body_impl != null) { this.create_procedure_body_impl._setParent(this); }
  }

  public void _walk(_visitor visitor) {
    if (!visitor.enter(this)) {
      return;
    }
    if (this.SQL92_RESERVED_CREATE != null) {
      visitor.visit(this.SQL92_RESERVED_CREATE);
    }
    if (this.REPLACE_VK != null) {
      visitor.visit(this.REPLACE_VK);
    }
    if (this.procedure_name != null) {
      this.procedure_name._walk(visitor);
    }
    if (this.parameters != null) {
      this.parameters._walk(visitor);
    }
    if (this.invoker_rights_clause != null) {
      this.invoker_rights_clause._walk(visitor);
    }
    if (this.create_procedure_body_impl != null) {
      this.create_procedure_body_impl._walk(visitor);
    }
    visitor.leave(this);
  }

  public java.util.List<_baseNode> _getChildren() {
    java.util.List<_baseNode> result = new java.util.ArrayList<_baseNode>();
    if (this.procedure_name != null) {
      result.add(this.procedure_name);
    }
    if (this.parameters != null) {
      result.add(this.parameters);
    }
    if (this.invoker_rights_clause != null) {
      result.add(this.invoker_rights_clause);
    }
    if (this.create_procedure_body_impl != null) {
      result.add(this.create_procedure_body_impl);
    }
    return result;
  }

  public void _replace(_baseNode child, _baseNode replacement) {
    if (this.procedure_name == child) {
      this.set_procedure_name((ru.barsopen.plsqlconverter.ast.typed.procedure_name)replacement);
      return;
    }
    if (this.parameters == child) {
      this.set_parameters((ru.barsopen.plsqlconverter.ast.typed.parameters)replacement);
      return;
    }
    if (this.invoker_rights_clause == child) {
      this.set_invoker_rights_clause((ru.barsopen.plsqlconverter.ast.typed.invoker_rights_clause)replacement);
      return;
    }
    if (this.create_procedure_body_impl == child) {
      this.set_create_procedure_body_impl((ru.barsopen.plsqlconverter.ast.typed.create_procedure_body_impl)replacement);
      return;
    }
    throw new RuntimeException("Failed to replace node: no such node");
  }

  public org.antlr.runtime.tree.Tree unparse() {
    org.antlr.runtime.CommonToken _token = new org.antlr.runtime.CommonToken(ru.barsopen.plsqlconverter.PLSQLPrinter.CREATE_PROCEDURE);
    _token.setLine(_line);
    _token.setCharPositionInLine(_col);
    _token.setText("CREATE_PROCEDURE");
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
    if (SQL92_RESERVED_CREATE != null) {
      _result.addChild(SQL92_RESERVED_CREATE);
    }


    if (REPLACE_VK != null) {
      _result.addChild(REPLACE_VK);
    }


    if (procedure_name == null) { throw new RuntimeException(); }
    _result.addChild(procedure_name.unparse());


    if (parameters == null) { throw new RuntimeException(); }
    _result.addChild(parameters.unparse());


    if (invoker_rights_clause != null) {
      _result.addChild(invoker_rights_clause.unparse());
    }


    if (create_procedure_body_impl == null) { throw new RuntimeException(); }
    _result.addChild(create_procedure_body_impl.unparse());


    return _result;
  }

}
