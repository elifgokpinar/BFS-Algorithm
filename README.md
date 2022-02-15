
<h2>Breadth First Search Algorithm</h2>
<div>
<h3>📃 Code algorithm </h3>
<ol>
<li>The program run from command line argument.</li>
<li>The test file is read. At the same time x,y and r are filled in the objects.</li>
<li>Objects are put in the array.</li>
<li>The first element of the array is chosen as the beginning point. So, Its hop distance value must be 0.</li>
<li>Then, distances are calculated with other points. If the distance is available for each of the two agents, the level of the second agent is set. So, for loop loops again the same situation.</li>
<li>If the agent level is set, we can not look at it again. We want to make a basic bfs spanning tree. So, we can only reach the unvisited agents.</li>
<li>Some agents’ hop distances can be 0 also.</li>
<li>In the end, all hop distances are in the objects. The output file contains hop distances of agents. For this, I used  <i>printWriter</i>.</li>
</ol>

</div>
<hr>
<ul>
<li>Time complexity O(n^2)</li>
</ul>
	



