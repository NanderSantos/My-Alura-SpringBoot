package com.nander.springdata.action;

@FunctionalInterface
public interface IEmployeeAction<Param1, Param2, Param3, Param4, Return> {

	public Return apply(Param1 param1, Param2 param2, Param3 param3, Param4 param4);
}
