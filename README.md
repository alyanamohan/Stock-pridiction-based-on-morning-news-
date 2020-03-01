# Inspiration
The vast majority of investors do not do it professionally. Therefore, they do not always have the time to do proper market research if they are trying day trading. This usually leads to poorly informed decisions, which can cause the average person to lose a lot of money.

# What it does
IntelliVast does market research for investors every morning before the markets open using NLP algorithms to analyze media sentiment, which has been shown to be a fair indicator of stock performance.

# How we built it
First we created a web scraper that mines data from the most reputable financial news companies using Selenium. The data is encoded in JSON format and sent over for NLP analysis. The NLP analysis uses a sentiment library to analyze whether the phrases in our article have positive or negative connotations. In order to model selected stocks on vibrational systems, we conduct Fast Fourier Transforms on stock data taken from the Yahoo! Finance API. We then pass the data through a low pass filter, and do a wavelet analysis on the data to determine if it would be modeled as a forced or free vibration. Now that we have performed our data analysis, we use an API request to transfer data from the back end to the front end. We then created a simple React app to display our daily data online.

# Challenges we ran into
Due to the fact that each team within our group was comfortable with different tech stacks, we needed to create a universal medium of data transfer. We decided to use JSON due to it's simplicity and compatibility with our tech stack. Unfortunately, we ran into a few issues with universality, functionality, and structural efficiency. It wasn't initially clear what set of parameters we would need for the NLP algorithms, and what set of parameters we would need for the web app, and so the JSON format was continually changing. Knowing that this problem would persist and cause unnecessarily poor productivity, we put our heads together to identify a few key parameters for our algorithm and decided on an efficient medium of data transfer that would work for all parties.

# Accomplishments that we're proud of
When we were first deciding our ideas, a lot of them seemed significantly easier, and wouldn't require as much collaboration. We decided on this idea knowing that there was a high chance we could never finish it. We are proud to have proven ourselves wrong, and completed everything to a much higher level than we thought we were capable of.

# What we learned
Due to the vast size of this project, and the limited time we had, high levels of efficiency and collaboration were not optional. We learned how to work around individual skill sets, delegate work efficiently, and structure our development for maximum efficiency. We also learned plenty of new libraries, frameworks, and algorithms particularly in NLP and automata.

# What's next for IntelliVast
In order to improve the accuracy of our stock predictions, we would like to develop web scrapers for more reputable news platforms in order to increase our sample size. We would also like to train our NLP model specifically on finance articles given that certain words have different connotations within the context of finance. Now that we have more time to do so, we plan on adding our new features and testing it on a fake stocks account with Investopedia. Once we are satisfied with the results of our algorithm, we would like to allow it to control a portion of our stock holdings, and slowly increment or decrement its holdings based on its performance.

![Slide 1](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-1.png)
![Slide 2](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-2.png)
![Slide 3](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-3.png)
![Slide 4](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-4.png)
![Slide 5](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-5.png)
![Slide 6](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-6.png)
![Slide 7](https://raw.githubusercontent.com/alexchomiak/hack-illinois/master/presentation-slides/slide-7.png)


