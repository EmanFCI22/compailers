/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

/**
 *
 * @author rawan
 */
public class Pair<Token,Expression>  {

    private Token comma;
    private Expression expression;

        public Pair(Token comma, Expression expression) 
        {
            this.comma = comma;
            this.expression = expression;
        }
        
        /**
         * @return the comma
         */
        public Token getComma() {
            return comma;
        }

        /**
         * @return the expression
         */
        public Expression getExpression() {
            return expression;
        }
        

 }
    