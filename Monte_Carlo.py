#https://www.youtube.com/watch?v=A0J0VAHzIxc
import numpy as np;
from pandas import Series, DataFrame
#%matplotlib inline
import matplotlib.pyplot as plots;
# allows currency formatting
import locale
locale.setlocale(locale.LC_ALL, '')

pv = 10000
expected_return = 0.09
time_horizon = 30
i = 0.07
annual_addition = 10000
volatility = 30

print("\tReturn", "\t\tEnding Value".rjust(18))
for year in range(time_horizon):
    market_return = np.random.normal(expected_return, volatility)
    fv = pv * (1 + market_return) + annual_addition
    print("\t{}".ljust(10).format(round(market_return,4)), "\t{}".rjust(10).format(locale.currency(fv, grouping=True)))
    pv = fv

sim = DataFrame()
iterations = 5000

for x in range(iterations):
    expected_return = 0.09
    volatility = 0.18
    time_horizon = 30
    pv = 10000
    annual_investment = 10000
    stream = []
    for i in range(time_horizon):
        end = round(pv * (1 + np.random.normal(expected_return, volatility)) + annual_investment, 2)

        stream.append(end)

        pv = end

    sim [x] = stream

#first_five = list(range(5))
#sim[first_five]
#plots.plot(sim[first_five])
print("Count:", len(sim.loc[29]))
print("Mean: ", locale.currency(np.mean(sim.loc[29]),grouping=True))
print("SD: ",locale.currency(np.std(sim.loc[29]),grouping=True))
print("Max: ",locale.currency(np.max(sim.loc[29]),grouping=True))
print("Min: ",locale.currency(np.min(sim.loc[29]),grouping=True))
ending_values = sim.loc[29]
ending_values.describe[]
#plots.hist[ending_values], bins=100]

len(ending_values[ending_values>1000000]) /len(ending_values)
len(ending_values[(ending_values>800000) & (ending_values<1100000)]) /len(ending_values)

p_tiles = np.percentile(ending_values,[5,10,15,25,75,85,90,95])
for p in range(len(p_tiles)):
    l = [5,10,15,25,75,85,90,95]
    print("{}%-ile: ".format(l[p]).rjust(15),"{}".format(locale.currency(p_tiles[p], grouping=True)))
