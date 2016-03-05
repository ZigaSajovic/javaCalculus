# javaCalculus
Symbolic differentiation and optimization.

Written for and tested on machine learning software, where analytic derivatives were needed. Expression trees are build as FunctionExpressions, library as is, does not parse strings. It supports compositions of functions.

Class "ExampleCalculus" contains the main method and examples of use.

Class "Function" contains instructions on adding functions to the base (method "evaluate)

Class "FunctionExpression" builds function expression trees out of functions.

Class "Calculus" contains instructions on adding derivative maps for added functions (method "derive"). The class performs evaluations of function expressions and differentiation. Derivatives are returned as analytic function expressions.
