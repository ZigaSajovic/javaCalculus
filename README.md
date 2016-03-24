# javaCalculus
Symbolic multivariate differentiation and optimization.

Written for and tested on machine learning software, where analytic derivatives were needed. Expression trees are build as FunctionExpressions, library as is, does not parse strings. It supports compositions of functions. The library is self contained, no dependacies outside java-built-in functionalities.

Class _ExampleCalculus_ contains the main method and examples of use.

Class _Function_ contains instructions on adding function mappings (method _evaluate_)

Class _FunctionExpression_ builds function expression trees out of functions.

Class _Calculus_ contains instructions on adding derivative maps for added functions (method _derive_). The class performs evaluations of function expressions and differentiation. Derivatives are returned as analytic function expressions. May be used for computation of analytic gradients, Hessians and other means of analytic approximations of functions.

Class _GradientDescent_ performs optimizations with an adaptave learning rate, based on default parameters. The boolean "saddle", when "true", transforms the problem into a space where all saddle points are local extrema;- to be used with Lagrangians.

Class _LeastSquares_ minimizes min|Ax-b|, it employs the _Matrix_ class provided here.

Other classes added, that may be helpful on projects in need of analytic derivatives. Such as EquationSolver, basic vector (_Vec_) and matrix (_Matrix_) algebra, basic statistics (_Stat_), distances in 3D space (point to line, line to line, etc.) 

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">javaCalculus</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="https://si.linkedin.com/in/zigasajovic" property="cc:attributionName" rel="cc:attributionURL">Žiga Sajovic</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>.
