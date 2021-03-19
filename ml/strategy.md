# Strategy backtesting

Incorporating an investment idea into a real-life algorithmic strategy implies a significant risk that requires a scientific approach. Such an approach involves extensive empirical tests with the goal of rejecting the idea based on its performance in alternative out-of-sample market scenarios. Testing may involve simulated data to capture scenarios deemed possible but not reflected in historic data.

To obtain unbiased performance estimates for a candidate strategy, we need a backtesting engine that simulates its execution in a realistic manner. In addition to the potential biases introduced by the data or a flawed use of statistics, the backtesting engine needs to accurately represent the practical aspects of trade-signal evaluation, order placement, and execution in line with market conditions.

### Objectives

- Trade execution algorithms that aim to achieve favorable pricing
- Short-term trades that aim to profit from small price movements, for example, due to arbitrage
- Behavioral strategies that aim to anticipate the behavior of other market participants
- Trading strategies based on absolute and relative price and return predictions

### Use cases of ML for trading

- Data mining to identify patterns, extract features, and generate insights
- Supervised learning to generate risk factors or alphas and create trade ideas
- The aggregation of individual signals into a strategy
- The allocation of assets according to risk profiles learned by an algorithm
- The testing and evaluation of strategies, including through the use of synthetic data
- The interactive, automated refinement of a strategy using reinforcement learning

### Data mining for feature extraction and insights

Information theory helps estimate a signal content of candidate features and is thus useful for extracting the most valuable inputs for an ML model

Unsupervised learning provides a broad range of methods to identify structure in data to gain insights or help solve a downstream task

odel transparency emphasizes model-specific ways to gain insights into the predictive power of individual variables and introduce a novel game-theoretic approach called SHapley Additive exPlanations (SHAP)

### Supervised learning for alpha factor creation

The most familiar rationale for applying ML to trading is to obtain predictions of asset fundamentals, price movements, or market conditions. A strategy can leverage multiple ML algorithms that build on each other:

- Downstream models can generate signals at the portfolio level by integrating predictions about the prospects of individual assets, capital market expectations, and the correlation among securities.

- lternatively, ML predictions can inform discretionary trades as in the quantamental approach outlined previously.

- ML predictions can also target specific risk factors, such as value or volatility, or implement technical approaches, such as trend-following or mean reversion

### Asset allocation

ML has been used to allocate portfolios based on decision-tree models that compute a hierarchical form of risk parity. As a result, risk characteristics are driven by patterns in asset prices rather than by asset classes and achieve superior risk-return characteristics.

### Reinforcement learning

Trading takes place in a competitive, interactive marketplace. Reinforcement learning aims to train agents to learn a policy function based on rewards; it is often considered as one of the most promising areas in financial ML. See, for example, Hendricks and Wilcox (2014) and Nevmyvaka, Feng, and Kearns (2006) for applications to trade execution.

