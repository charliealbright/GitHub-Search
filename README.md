# Github Search
## Hey AA!

This is my repository for the Github Search Android application. Overall, I had an awesome time working on this project, and I hope you enjoy my rendition of the assignment!

### My Thoughts
During this project, I tried to focus on providing a clean and simple UI as well as a solid user experience. I did have less time than I had hoped to work on the project due to the fact that I was moving apartments this past weekend, so I didn't get to as many of my enhancements as I wanted to - but regardless, I am extremely happy with how the application turned out.

This was my first time building a MVP-architected app from scratch. I'd worked with apps that followed the MVP design principles, but it was a great experience to be able to architect the app in an MVP fashion from it's inception.

I also religiously tracked my progress on the app through Github issues. I found it to be a helpful way to break up the app into manageable tasks that could be completed relatively quickly, and also a way to jot down a bug or two as I ran across them during development. I also made use of Github's Milestones, so you all can go check those out in the repo as well.

### Enhancements
If I had additional time to work on the project, these were some of the features/enhancements I had planned on adding:
1. Infinite Scrolling of Search Results
   * This feature would allow the user to scroll down an "infinite" list of users found in a given search. The Github API only returns a default of 30 results at a time, but using their Pagination feature, the next 30 items can be requested quickly by adding a URL parameter to the request. Adding a ScrollListener to the Recyclerview could facilitate loading more items as the user approaches the end of the list.
   * Github has a rate limit on their Search API, so this would be a challenge to implement without exceeding the rate limit.
2. Advanced Search Filter support
   * Github's Search API has a robust filtering mechanism that allows a user to narrow their search. I would love to develop a UI for this to make filtering results a breeze for the user.
3. User Detail landscape layout support.
   * I would love to develop a separate landscape UI for the User Detail screen.
   
### Finally...
I hope you guys enjoy looking through my work! If you have any questions, feel free to reach out! 

Obligatory pet tax, my dog Archie with my workstation in the background:
<div align="center"><img src="http://i.imgur.com/xOSVRqZ.jpg" style="width:50%"></div>
