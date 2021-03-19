"This law defines the information ratio (IR) to express the value of active management as the ratio of the return difference between the portfolio and a benchmark to the volatility of those returns. It further approximates the IR as the product of the following:


- The information coefficient (IC), which measures the quality of forecasts as their rank correlation with outcomes

- The square root of the breadth of a strategy expressed as the number of independent bets on these forecasts

"

"The fundamental law of active management postulates that the key to generating alpha is having accurate return forecasts combined with the ability to act on these forecasts (Grinold 1989; Grinold and Kahn 2000)."

"The competition of sophisticated investors in financial markets implies that making precise predictions to generate alpha requires superior information, either through access to better data, a superior ability to process it, or both.
"

### Agorithmic Trading Trends

- Changes in the market microstructure, such as the spread of electronic trading and the integration of markets across asset classes and geographies

- The development of investment strategies framed in terms of risk-factor exposure, as opposed to asset classes

- The revolutions in computing power, data generation and management, and statistical methods, including breakthroughs in deep learning

- The outperformance of the pioneers in algorithmic trading relative to human, discretionary investors

### Electronic & High-frequency trading

ECNs are automated alternative trading systems (ATS) that match buy-and-sell orders at specified prices, primarily for equities and currencies, and are registered as broker-dealers. It allows significant brokerages and individual traders in different geographic locations to trade directly without intermediaries, both on exchanges and after hours.

Dark pools are another type of private ATS that allows institutional investors to trade large orders without publicly revealing their information, contrary to how exchanges managed their order books prior to competition from ECNs.

Direct market access (DMA) gives a trader greater control over execution by allowing them to send orders directly to the exchange using the infrastructure and market participant identification of a broker who is a member of an exchange. Sponsored access removes pre- trade risk controls by the brokers and forms the basis for high-frequency trading (HFT).

HFT refers to automated trades in financial instruments that are executed with extremely low latency in the microsecond range and where participants hold positions for very short periods. The goal is to detect and exploit inefficiencies in the market microstructure, the institutional infrastructure of trading venues.

HFT strategies aim to earn small profits per trade using passive or aggressive strategies. Passive strategies include arbitrage trading to profit from very small price differentials for the same asset, or its derivatives, traded on different venues. Aggressive strategies include order anticipation or momentum ignition. Order anticipation, also known as liquidity detection, involves algorithms that submit small exploratory orders to detect hidden liquidity from large institutional investors and trade ahead of a large order to benefit from subsequent price movements. Momentum ignition implies an algorithm executing and canceling a series of orders to spoof other HFT algorithms into buying (or selling) more aggressively and benefit from the resulting price changes.

The largest listed proprietary trading firm, Virtu Financial, and shared infrastructure investments, such as the new Go West ultra-low latency route between Chicago and Tokyo. Simultaneously, start- ups such as Alpha Trading Labs are making HFT trading infrastructure and data available to democratize HFT by crowdsourcing algorithms in return for a share of the profits.

### Factor investing and smart beta funds

The return provided by an asset is a function of the uncertainty or risk associated with
the investment. An equity investment implies, for example, assuming a company's business risk, and a bond investment entails default risk. To the extent that specific risk characteristics predict returns, identifying and forecasting the behavior of these risk factors becomes a primary focus when designing an investment strategy. It yields valuable trading signals and is the key to superior active-management results. The industry's understanding of risk factors has evolved very substantially over time and has impacted how ML is used for trading.

Assets earn a risk premium based on their exposure to underlying, common risks experienced by all assets, not due to their specific, idiosyncratic characteristics.

The EMH maintains that market equilibrium would always price securities according to the CAPM so that no other factors should have predictive power (Malkiel 2003). The economic theory behind factors can be either rational, where factor risk premiums compensate for low returns during bad times, or behavioral, where agents fail to arbitrage away excess returns.

Well-known anomalies include the value, size, and momentum effects that help predict returns while controlling for the CAPM market factor. The size effect rests on small firms systematically outperforming large firms (Banz 1981; Reinganum 1981). The value effect (Basu et. al. 1981) states that firms with low valuation metrics outperform their counterparts with the opposite characteristics. It suggests that firms with low price multiples, such as the price-to-earnings or the price-to-book ratios, perform better than their more expensive peers (as suggested by the inventors of value investing, Benjamin Graham and David Dodd, and popularized by Warren Buffet).

The momentum effect, discovered in the late 1980s by, among others, Clifford Asness, the founding partner of AQR, states that stocks with good momentum, in terms of recent 6-12 month returns, have higher returns going forward than poor momentum stocks with similar market risk. Researchers also found that value and momentum factors explain returns for stocks outside the US, as well as for other asset classes, such as bonds, currencies, and commodities, and additional risk factors (Jegadeesh and Titman 1993; Asness, Moskowitz, and Pedersen 2013).

In fixed income, the value strategy is called riding the yield curve and is a form of the duration premium. In commodities, it is called the roll return, with a positive return for an upward-sloping futures curve and a negative return otherwise. In foreign exchange, the value strategy is called carry.

There is also an illiquidity premium. Securities that are more illiquid trade at low prices and have high average excess returns, relative to their more liquid counterparts. Bonds with a higher default risk tend to have higher returns on average, reflecting a credit risk premium. Since investors are willing to pay for insurance against high volatility when returns tend to crash, sellers of volatility protection in options markets tend to earn high returns.

Multifactor models define risks in broader and more diverse terms than just the market portfolio. In 1976, Stephen Ross proposed the arbitrage pricing theory, which asserted that investors are compensated for multiple systematic sources of risk that cannot be diversified away (Roll and Ross 1984). The three most important macro factors are growth, inflation, and volatility, in addition to productivity, demographic, and political risk. In 1993, Eugene Fama and Kenneth French combined the equity risk factors' size and value with a market factor into a single three-factor model that better explained cross-sectional stock returns. They later added a model that also included bond risk factors to simultaneously explain returns for both asset classes (Fama and French 1993; 2015).

### Algorithmic Pinoeers

Systematic strategies that mostly or exclusively rely on algorithmic decision-making were most famously introduced by mathematician James Simons, who founded Renaissance Technologies in 1982 and built it into the premier quant firm. Its secretive Medallion Fund, which is closed to outsiders, has earned an estimated annualized return of 35 percent
since 1982.

D. E. Shaw, Citadel, and Two Sigma, three of the most prominent quantitative hedge funds that use systematic strategies based on algorithms, rose to the all-time top-20 performers for the first time in 2017, in terms of total dollars earned for investors, after fees, and since inception.

D. E. Shaw, founded in 1988 and with $50 billion in AUM in 2019, joined the list at number 3. Citadel, started in 1990 by Kenneth Griffin, manages $32 billion, and ranked 5. Two Sigma, started only in 2001 by D. E. Shaw alumni John Overdeck and David Siegel, has grown from $8 billion in AUM in 2011 to $60 billion in 2019. Bridgewater, started by Ray Dalio in 1975, had over $160 billion in AUM in 2019 and continues to lead due to its Pure Alpha fund, which also incorporates systematic strategies.

### Quantamental Approaches

systematic (or quant) and discretionary investing. Systematic approaches rely on algorithms for a repeatable and data-driven approach to identify investment opportunities across many securities. In contrast, a discretionary approach involves an in-depth analysis of the fundamentals of a smaller number of securities. These two approaches are becoming more similar as fundamental managers take more data science-driven approaches.

Point72, with $14 billion in assets, has been shifting about half of its portfolio managers to a human-plus-machine approach. Point72 is also investing tens of millions of dollars into a group that analyzes large amounts of alternative data and passes the results on to traders.

Guggenheim Partners built what it calls a supercomputing cluster for $1 million at the Lawrence Berkeley National Laboratory in California to help crunch numbers for Guggenheim's quant investment funds. Electricity for computers costs another $1 million per year.

### Alternative data

Conventional data includes economic statistics, trading data, or corporate reports. Alternative data is much broader and includes sources such as satellite images, credit card sales, sentiment analysis, mobile geolocation data, and website scraping, as well as the conversion of data generated in the ordinary course of business into valuable intelligence. It includes, in principle, any data source containing (potential) trading signals.

For instance, data from an insurance company on the sales of new car insurance policies captures not only the volumes of new car sales but can be broken down into brands sor geographies. Many vendors scrape websites for valuable data, ranging from app downloads and user reviews to airline and hotel bookings. Social media sites can also be scraped for hints on consumer views and trends.

Real-time insights into a company's prospects, long before their results are released, can be gleaned from a decline in job listings on its website, the internal rating of its chief executive by employees on the recruitment site Glassdoor, or a dip in the average price of clothes
on its website. Such information can be combined with satellite images of car parks and geolocation data from mobile phones that indicate how many people are visiting stores.

On the other hand, strategic moves can be learned from a jump in job postings for specific functional areas or in certain geographies.
Among the most valuable sources is data that directly reveals consumer expenditures, with credit card information as a primary source. This data offers only a partial view of sales trends, but it can offer vital insights when combined with other data. Point72, for instance, at some point analyzed 80 million credit card transactions every day.

WorldQuant, Quantopian, and, most recently, Alpha Trading Labs (launched
in 2018).

### Designing and executing an ML-driven strategy

To this end, we'll assume that an ML-based strategy is driven by data sources that contain predictive signals for the target universe and strategy, which, after suitable preprocessing and feature engineering, permit an ML model to predict asset returns or other strategy inputs. The model predictions, in turn, translate into buy or sell orders based on human discretion or automated rules, which in turn may be manually encoded or learned by another ML algorithm in an end-to-end approach.


