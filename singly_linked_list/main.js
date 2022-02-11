
class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

function Context(source, dest) {
  this.source = source;
  this.dest = dest;
}

function display(head) {
  console.log(head ? 'current data: ' + head.data : 'END');
  return head ? display(head.next) : null;
}

function push(head, data) {
  const node = new Node(data);
  node.next = head;
  return node;
}

function insertNth(head, index, data) {
  if (index === 0) return push(head, data);
  if (!head) throw 'bad index';
  head.next = insertNth(head.next, index - 1, data);
  return head;
}

function sortedInsert(head, data) {
  if (!head || head.data > data) return push(head, data);
  head.next = sortedInsert(head.next, data);
  return head;
}

function insertSort(head) {
  return head ? sortedInsert(insertSort(head.next), head.data) : head;
}

function append(listA, listB) {
  if (!listA) return listB;
  listA.next = append(listA.next, listB);
  return listA;
}

function removeDuplicates(head) {
  if (head && head.next) head.next = removeDuplicates(head.next);
  else return head;
  return head.data === head.next.data ? head.next : head;
}

function moveNode(source, dest) {
  if (!source) throw 'invalid context';
  return new Context(source.next, new Node(source.data, dest));
}

function length(head) {
  // return 0 if the head is null
  // return 1 plus the result of the length function given the next node from the head
  return head ? length(head.next) + 1 : 0;
}

function count(head, data) {
  // return 0 if the head is null
  // return 1 if the node data is equal to the data, plus the result of the count function given the next node -> head.next
  // the result looks something like 0 + 1 + 1 + 0 + 1 + 0 or whatever // the last zero being for a null head.next
  return head ? count(head.next, data) + ( head.data === data ? 1 : 0 ) : 0;
}

function getNth(node, index) {
  // if the head is null then the index is greater than the length of the list
  // return an out of range error
  if (!node) throw 'bad no';
  // if the index is 0 then the function has counted down from the original index to 0
  // if the index isn't 0 then try the next node with an index of 1 less than the current index
  return index === 0 ? node : getNth(node.next, index - 1);
}

//  this was in beta and had many errors
// function moveNodeInPlace(source, dest) {

//   if (!source || !dest) throw 'invalid context'
//   dest = push(dest, dest.data)
//   source = source.next
// }

//  INCOMPLETE ----- FINSIH JED ! ! !
// function alternatingSplit(head) {

//   var next = head.next
//   next.next // throws error if null
//   var context = new Context(head, next)

//   while (next) head.next, head, next = next.next, next, next.next
//   return context
// }

// non recursive remove duplicates
function _removeDuplicates(head) {
  if (!head) return head;
  var result = head;
  while (head.next) {
    if (head.next.data === head.data) head.next = head.next.next;
    else head = head.next;
  }
  return result;
}

function frontBackSplit(source, front, back) {
  // things
}


function shuffleMerge(first, second) {

  if (first) first.next = shuffleMerge(second, first.next)
  return first || second
}


function sortedMerge(first, second) {
  
  if(!first || !second) return first || second
  if (first.data > second.data) [first, second] = [second, first]
  first.next = sortedMerge(first.next, second)
  return first
}

// // oh no
// function mergeSort(list) {
  
//   if (!list || !list.next) return list
//   var a, b = Node
//   frontBackSplit(list, a, b)
//   return sortedMerge(mergeSort(a), mergeSort(b))
// }


function sortedIntersect(first, second) {
  // do things ?
}

// mal
function iterativeReverse(list) {

  var [head, node] = [null, list]
  while(node) [head, node] = [push(head, node.data), node.next]
  if(list) Object.assign(list, head)
  return head
}

// recursive solution
function reverse(head, prev = null) {

  // safest solution
  // return head && head.next ? reverse(head.next, push(prev,head.data)) : head ? push(prev, head.data) : null
  // shortest solution
  return head ? reverse(head.next, new Node(head.data, prev)) : prev
}


function deleteNode(node) {

  if (node && node.next) {
    [node.data, node.next] = [node.next.data, node.next.next]
  }
}

function buildOneTwoThree() {
  return push(push(push(null,3), 2), 1);
}