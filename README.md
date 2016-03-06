# javaCalculus
Symbolic multivariate differentiation and optimization.

Written for and tested on machine learning software, where analytic derivatives were needed. Expression trees are build as FunctionExpressions, library as is, does not parse strings. It supports compositions of functions. The library is self contained, no dependacies outside java-built-in functionalities.

Class "ExampleCalculus" contains the main method and examples of use.

Class "Function" contains instructions on adding function mappings (method "evaluate")

Class "FunctionExpression" builds function expression trees out of functions.

Class "Calculus" contains instructions on adding derivative maps for added functions (method "derive"). The class performs evaluations of function expressions and differentiation. Derivatives are returned as analytic function expressions. May be used for computation of analytic gradients, Hessians...

Class "GradientDescent" performs optimizations with an adaptave learning rate, based on default parameters. The boolean "convex", when "false", transforms the problem into a space where all saddle points are local extrema;- to be used with Lagrangians.

Class "LeastSquares" minimizes min|Ax-b|, it employs the "Matrix" class provided here.

Other classes added, that may be helpful on projects in need of analytic derivatives. Such as EquationSolver, basic vector (Vec) and matrix (Matrix) algebra, basic statistics (Stat), distances in 3D space (point to line, line to line, etc.) 

All are free to employ and modify for personal use.
