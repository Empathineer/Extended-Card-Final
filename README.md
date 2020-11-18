# Extended-Card-Final

<div class="description user_content student-version enhanced jqueryUIWidgetized"><h1 style="text-align: center;">Managing a Sorted java.util List and java.util Stack</h1>

<h3><u>Objective</u></h3>
<p>Previously, we instantiated a <strong>java.util</strong> <strong>LinkedList</strong> of <strong>Floats</strong> and integrated an some<strong> insert()</strong> and <strong>remove()</strong> method on the client side that managed the list in increasing sorted order.&nbsp; In this assignment, the same will be applied for <strong>Card</strong> objects following the natural order that was established before.&nbsp;</p>
<p>One previous class and two new components will incoporated:</p>
<ol>
<li>The <strong>Card</strong> class from <span style="color: #800080;"><i><strong>Assignment #1</strong></i></span>.</li>
<li>
<strong>compareTo()</strong> mechanism for the Card class, supplied below.</li>
<li>A <strong>generateRandomCard()</strong> method</li>
</ol>
<p>Two client-side static class methods <strong> insert()</strong>,<strong> remove()</strong> and <strong> removeAll()</strong> will be implemented. They accept a <strong>java.util</strong> <strong>LinkedList</strong> of <strong>Card</strong>s (first parameter) and a <strong>Card</strong> (second parameter).&nbsp;</p>
<h3><u>Main Highlights of LinkedList Function</u></h3>
<ul>
<li>
<strong>static boolean removeAll(LinkedList&lt;Card&gt; my_List, Card x))</strong> - Notice that this method returns a <strong>boolean</strong> which should be <strong>true</strong> if <strong>x</strong> was in the list, and <strong>false</strong> if it was not.</li>
<li><strong>compareTo()</strong> nested within the <strong>insert()</strong> and/or <strong>remove()</strong> methods, as needed, for <i>any</i> test:&nbsp; <i>equality</i>,<i> less than</i> or <i>greater than</i>.</li>
<li>equality is based on <strong>Card</strong>'s <strong>compareTo()</strong>, not based on field-by-field comparisons.</li>
</ul>

<h4>Client Side Requirements</h4>
<ol>
<li><p>Instantiate about five to ten cards randomly (using the <i><strong> <span style="color: #800080;">lab #1</span></strong></i> code), but produce duplicates of every card in the list:&nbsp; every card you generate goes into your list <i>twice</i>.&nbsp; Display the list immediately after you build it.&nbsp; (Note, you might have four, not two, of some cards because of <strong>generateRandomCard()</strong>, and that's fine.&nbsp; (Maybe even six or eight or ... .)</p></li>
<li><p>Display the list.</p></li>
<li><p>Next, about half of the cards were inserted for removal but done as follows.&nbsp; If five cards were initially instantiated, they were put into the list twice, generating a list of now 10 cards.&nbsp; Then, say two distinct cards were picked from the initial five and <strong>remove()</strong> all traces of each of those two cards.&nbsp; In order to remove only one instance of each card, the <strong> remove()</strong> had to be called here, not <strong> removeAll()</strong>.&nbsp; Therefore, it will need to be done repeatedly for the same card.&nbsp; For example, if <i><strong>3 of diamonds</strong></i> is a card, remove <i>all</i> copies of <i><strong>3 of Diamonds</strong></i>, not just the first.&nbsp; One must assume the client does not know how many copies of the <i><strong>3 of diamonds</strong></i> are in the list, so instead, an intelligent loop calling<strong>remove()</strong> must iterate recursively until the return value of<strong> remove()</strong> tells you the loop is done.&nbsp;</p></li>
<li><p>Display the list and confirm that it looks right after the removal.</p></li>
<li><p>Finally, test <strong>removeAll()'</strong>s return value somehow after the above test.<i><strong><span style="color: #993366;">&nbsp;</span></strong></i></p></li>
</ol>



</div>
