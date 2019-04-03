# linked_list:

class Node(object):
  def __init__(self, data, next = None):
    self.data = data
    self.next = next

class Context(object):
  def __init__(self, source, dest):
    self.source = source
    self.dest = dest

class _Context(object):
  def __init__(self, first, second):
    self.first = first
    self.second = second

def push(head, data):
  node = Node(data)
  node.next = head
  return node


def build_one_two_three():
  return push(push(push(None, 3), 2), 1)


def length(node):
  return 1 + length(node.next) if node else 0


def count(node, data):
  return (count(node.next, data) + (1 if node.data == data else 0)  ) if node else 0


def get_nth(node, index):
  if not node: raise Exception('bad')
  return node if index == 0 else get_nth(node.next, index - 1)

# my solution
def insert_nth(head, index, data):
  if index == 0: return push(head, data)
  if not head: raise IndexError
  head.next = insert_nth(head.next, index - 1, data)
  return head

# a solution I like
def _insert_nth(head, index, data):
  return Node(data, head) if not index else Node(head.data, _insert_nth(head.next, index - 1, data))


def sorted_insert(head, data):
  if not head or head.data > data: return push(head, data)
  head.next = sorted_insert(head.next, data)
  return head


def insert_sort(head):
  return sorted_insert(insert_sort(head.next), head.data) if head else None

# mine
def append(listA, listB):
  if not listA : return listB
  listA.next = append(listA.next, listB)
  return listA

  # notmine
def _append(listA, listB):
  return listB if not listA else Node(listA.data, _append(listA.next, listB))

# this works perfectly but codewars wants a non recursive solution
def remove_duplicates(head):
  if head and head.next: head.next = remove_duplicates(head.next)
  else: return head
  return head.next if head.data == head.next.data else head

# non recursive version
def _remove_duplicates(head):
  if not head: return head
  result = head
  while head.next:
    if head.next.data == head.data: head.next = head.next.next
    else: head = head.next
  return result


def move_node(source, dest):
  if not source: raise ValueError
  return Context(source.next, Node(source.data, dest))

# idk whats up with this one
def move_node_in_place(source, dest):
  if source is None or dest is None: raise ValueError
  dest = push(dest, dest.data)
  source = source.next

# solution I found
# def _move_node_in_place(source, dest):
#   if not source or not dest or not source.data: raise ValueError
#   global source1
#   global dest1
#   front = source1.data
#   source1 = source1.ext or Node()
#   dest1 = not dest1.data and Node(front) or Node(front, dest1)


def alternating_split(head):
  next = head.next
  next.next # this throws an error if it's = None
  context = Context(head, next)

  while next:
    head.next, head, next = next.next, next, next.next

  return context


def front_back_split(source, front, back):
  assert source or source.next
  f, b = source.next, source
  while f and f.next:
    f, b = f.next.next, b.next
  back.data, back.next = b.next.data, b.next.next
  b.next = None
  front.data, front.next = source.data, source.next


def shuffle_merge(first, second):
  if first:
    first.next = shuffle_merge(second,first.next)
  return first or second


def sorted_merge(first, second):
  if not first or not second: return first or second
  if first.data > second.data: first, second = second, first
  first.next = sorted_merge(first.next, second)
  return first


# incomplete - timed out 
def merge_sort(list):
  if not list or not list.next: return list
  a, b = Node, Node

  front_back_split(list, a, b)
  return sorted_merge(merge_sort(a), merge_sort(b))


def sorted_intersect(f, s):
  if not f or not s: return None
  diff = f.data - s.data
  if diff != 0:
    return sorted_intersect( f if diff > 0 else f.next, s.next if diff > 0 else s )
  head = sorted_intersect(f.next, s.next)
  if not head: return push(head, f.data)
  return head if head.data == f.data else push(head, f.data)


# this was a recursive reverse kata and I reached the maximum recursion depth on codewars
def reverse(head, prev = None):
  return reverse( head, push(prev, head.data)) if head else prev


# found on leetcode
def delete_node(node: Node):
  if node and node.next:
    node.data, node.next = node.next.data, node.next.next