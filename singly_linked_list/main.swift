
// Nodes and singly linked lists
import Foundation

// Node
class Node {

    var data: Int
    var next: Node?

    init(_ data: Int) {
        self.data = data
    }

    convenience init(data: Int, next: Node?) {
        self.init(data)
        self.next = next
    }
}

struct Context {
    var source:Node?
    var dest:Node?
}

// Linked lists
class LinkedList {

    var head: Node?

    var tail: Node? {
        get {
            return last(head)
        }
    }

    func insert(data: Int) {

        // if the list is empty
        if head == nil {
            head = Node(data)
            return
        }

        var current = head

        while current?.next != nil {
            current = current?.next
        }

        current?.next = Node(data)
    }


    func delete(data: Int) {

        if head?.data == data {
            head = head?.next
        }

        var previous: Node?
        var current = head

        while current != nil && current?.data != data {
            previous = current
            current = current?.next
        }

        previous?.next = current?.next
    }


    func insertInOrder(data: Int) {

        if head == nil || head?.data ?? Int.min >= data {
            let newNode = Node(data)
            newNode.next = head
            head = newNode
        }

        var current: Node? = head

        while current?.next != nil && current?.next?.data ?? Int.min < data {
            current = current?.next
        }

        current?.next = Node(data)
        // this line below might cause issues
        current?.next?.next = current?.next
    }

    
    func displayList(_ head: Node?) {

        // if the head is nil it will print - END signifying the end of the list
        print("current data :", head?.data ?? "- END")
        // if the head is not nil - display the next value
        head != nil ? displayList(head?.next) : nil
    }

//}


// below are all functions from codewars
// a lot of theses are recursive
// serveral call the push function


    func sortedInsert(_ head: Node?, _ data: Int) -> Node? {

        // return the result of pushing a new node if the head is nil
        guard let current = head else { return push(head, data) }

        current.next = sortedInsert(current.next, data)
        return current
    }

    func insertSort(head: Node?) -> Node? {

        guard let head = head else { return nil }

        // this is a two liner solution that relies on the sortedInsert function
        return sortedInsert(insertSort(head: head.next), head.data)
    }


    func length(_ head: Node?) -> Int {

        // return 0 if the head is nil
        // return 1 plus the result of the length function given the next node from the head
        // the result looks somthing like 1 + 1 + 1 + 0 // the last 0 being for a nil head.next
        return head != nil ? length(head?.next) + 1 : 0
    }


    func count(_ head: Node?, _ data: Int) -> Int {

        // return 0 if the head is nil
        // return 1 if the node data is equal to the data, plus the result of the count function given the next node -> head.next
        // the result looks something like 0 + 1 + 1 + 0 + 1 + 0 or whatever // the last zero being for a nil head.next
        return head != nil ? count(head!.next, data) + (head!.data == data ? 1 : 0) : 0
    }


    func last(_ head: Node?) -> Node? {

        // if head is nil then it will return nil
        // if head.next is nil it will return head
        // if head.next is not nil it will continue until it finds a nil value - the end of the list
        return head?.next == nil ? head : last(head?.next)
    }

    func append(_ listA:Node?, _ listB:Node?) -> Node? {

        // if there is no listA - return listB - nobody cares if listB is nil
        guard let listA = listA else { return listB }

    //    // set the end nodes next = to listB
    //    last(listA)?.next = listB // this was my original solution - which works fine

        // I like this better since it doesnt count on another function
        listA.next = append(listA.next, listB)

        return listA
    }


    func removeDuplicates(head:Node?) -> Node? {

        // calls itself until the head given to the function is nil
        head?.next = removeDuplicates(head: head?.next)

        return head?.data == head?.next?.data ? head?.next : head
    }

    class InvalidContext: Error {}

    func moveNode(source:Node?, dest:Node?) throws -> Context? {

        // if there is not at least two nodes, then the source will be nil
        // who cares if the dest is nil
        guard let next = source?.next else { throw InvalidContext() }

        source!.next = dest

        return Context(source: next, dest: source)
    }



    // this one was in beta
    func moveNodeInPlace(_ source:inout Node?, _ dest: inout Node?) throws {

        guard source != nil, dest != nil else { throw InvalidContext() }

        dest = push(dest, dest!.data)
        source = source?.next
    }


    // had trouble with this one
    func alternatingSplit(head:Node?) throws -> Context? {

        guard let nextData = head?.next?.data else { throw InvalidContext() }

        let context = Context(source: Node(head!.data), dest: Node(nextData))
        var current = context.source
        var next = context.dest

        var fast: Node? = head?.next?.next

        while fast != nil {

            let copy = Node(fast!.data)
            current?.next = copy
            current = next
            next = copy
            fast = fast!.next
        }

        return context
    }



    // I didn't have a clue what was being asked I guess
    // this is a solution I found

    class InvalidSourceArg: Error {}

    func frontBackSplit(source: Node?, front: inout Node?, back: inout Node?) throws {

        guard source?.next != nil else { throw InvalidSourceArg() }

        front = source
        back = source

        while back?.next?.next != nil {

            front = front?.next
            back = back?.next?.next
        }

        back = front?.next
        front?.next = nil
        front = source
    }


    func shuffleMerge(first: Node?, second: Node?) -> Node? {
        first?.next = shuffleMerge(first: second, second: first?.next)
        // return the second node if first is nil
        // doesn't matter if second is nil if first is nil // this also applies to my original solution
        return first ?? second
    }



    func sortedMerge(first:Node?, second:Node?) -> Node? {
        // I used variables instead of constants because a nand b potentially swap values
        guard var a = first, var b = second else { return first ?? second }
        // this lets you swap a and b without creating a new node
        a.data > b.data ? (a, b) = (b, a) : nil
        a.next = sortedMerge(first: a.next, second: b)
        return a
        // this shortens the function by one line but does rely on the push function
        // push is also only one line
    //    guard var a = first, var b = second else { return first ?? second }
    //    a.data > b.data ? (a, b) = (b, a) : nil
    //    return push(sortedMerge(first: a.next, second: b), a.data)
    }


    func mergeSort(_ list:Node?) -> Node? {
        // as soon as a nil value is found, return the list, which could be nil
        guard list != nil, list?.next != nil else { return list }
        var a :Node?, b: Node?
        try? frontBackSplit(source: list, front: &a, back: &b)
        return sortedMerge(first: mergeSort(a), second: mergeSort(b))
    }



    func SortedIntersect(first:Node?, second:Node?) -> Node? {

        guard let a = first, let b = second else { return nil }

        let diff = a.data - b.data

        if diff != 0 {
            return SortedIntersect(first: diff > 0 ? a : a.next, second: diff > 0 ? b.next : b)
        }

        let head = SortedIntersect(first: a.next, second: b.next)

        return head?.data == a.data ? head : push(head, a.data)
    }

    // this out of range error is just a cheapo way to not create an actually error message and case and stuff
    class IndexOutOfRange: Error {}

    func getNth(_ head: Node?, _ index: Int) throws -> Node? {

        // if the head is nil then the index is greater than the length of the list
        // return an out of range error
        guard let head = head else { throw IndexOutOfRange() }

        // if the index is 0 then the function has counted down from the original index to 0
        // if the index isn't 0 then try the next node with an index of 1 less than the current index
        return index == 0 ? head : try getNth(head.next, index - 1)
    }


    func insertNth(_ head: Node?, _ index: Int, _ data: Int) throws -> Node? {

        // if the index is = to 0 then the correct position has been found
        // return the new node with a next value of the current node - head
        if index == 0 {
            return push(head, data)
        }

        // if the index hasn't gotten to 0 and the head is nil then the end of the list has been reached
        // throw an error yo
        guard let head = head else { throw IndexOutOfRange() }

        head.next = try insertNth(head.next, index - 1, data)

        return head
    }


    func push(_ head:Node?, _ data:Int) -> Node {

        // with convenience init
        return Node(data: data, next: head)
    }

    // not super important - still matters tho
    func buildOneTwoThree() -> Node {

        return push(push(push(nil, 3), 2), 1)
    }


    // Iterative Reverse
    // this creates a new list in reverse order
    func reverse(list:inout Node?) {

        var result: Node?

        while list != nil {

            result = push(result, list!.data)
            list = list?.next
        }

        list = result
    }


    func recursiveReverse(list:Node?, previous: Node? = nil) -> Node? {

        guard let next = list?.next else { return list == nil ? nil : push(previous, list!.data) }

        return recursiveReverse(list: next, previous: push(previous, list!.data))
    }

    // a one line version of the function above
    // this does not create any new values - but does look rediculous
    func _recursiveReverse(list:Node?, _ pre: Node? = nil) -> Node? {

        return list?.next != nil ? _recursiveReverse(list: list?.next, push(pre, list!.data)) : list == nil ? nil : push(pre, list!.data)
    }

    func popLast(list: Node?) {

    }

}