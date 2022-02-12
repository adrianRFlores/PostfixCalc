class PosfixCalc implements IPosfixCalc{

	/***
	 * This method is used to evaluate a postfix expression
	 * @param expresion this is a single expression like: 1 2 + 4 * 3 +
	 * @return the evaluation of the expression
	 */
	@Override
	public int Evaluate(String expresion){
		StackArrayList<Integer> stack = new StackArrayList<Integer>();
		int op1, op2;
		for(int i = 0; i < expresion.length(); i++){
			if(Character.isDigit(expresion.charAt(i))){
				stack.push(Character.getNumericValue(expresion.charAt(i)));
			}
			else if(!Character.isWhitespace(expresion.charAt(i))){
				try{
					op2 = stack.pull();
					op1 = stack.pull();
					switch(Character.toString(expresion.charAt(i))){
						case "+":
							stack.push(op1 + op2);
							break;
						case "-":
							stack.push(op1 - op2);
							break;
						case "*":
							stack.push(op1 * op2);
							break;
						case "/":
							try{
								stack.push(op1 / op2);
							} catch(ArithmeticException e){
								return 0;
							}
							break;
					}
				} catch(Exception e){
					return 0;
				}
			}
		}
		return stack.peek();
	}
}