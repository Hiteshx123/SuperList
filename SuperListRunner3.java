public class SuperListRunner3
{
	public static void main (String [] args)
	{
		SuperList list = new SuperList();

		list.add(0, 20);
		list.add(2);
		list.add(8);
		list.add(14);
		list.add(10, 100);//OOB
		list.add(0, 20);
		list.add(-1, 47);//OOB
		list.add(5, 16);
		list.add(4, 2);

		System.out.println(list.size());
		System.out.println(list);
		//output
		//7
		//[20, 20, 2, 8, 2, 14, 16]

		list.clear();

		for(int i = 0; i < 10; i++)
			list.push(i);

		System.out.println(list.size());
		System.out.println(list);
		//output
		//10
		//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

		SuperList list2 = new SuperList();


		for(int i = 0; i < 5; i++)
		{
			list2.add(list.pop());
			list2.add(list.poll());
		}


		System.out.println(list2.size());
		System.out.println(list2);
		try {
			//System.out.println(list);
			list2.add(list.pop()); //stackErr
			list2.add(list.poll());//null
		} catch(NullPointerException E){
			E.printStackTrace();
		}

		System.out.println(list2.size());
		System.out.println(list2);
		//output
		//10
		//[9, 0, 8, 1, 7, 2, 6, 3, 5, 4]


		System.out.println(list2.stackPeek());
		System.out.println(list2.queuePeek());
		System.out.println(list2.size());
		//output
		//4
		//9
		//10

		list2.clear();
		try {
		System.out.println(list2.stackPeek());//stackErr
		System.out.println(list2.queuePeek());//null
		} catch (NullPointerException E){
			E.printStackTrace();
		}
		System.out.println(list2.size());
		//output
		//0

		SuperList list3 = new SuperList();

		for(int i = 0; i < 50; i++)
			list3.add(i);

		for(int i = 0; i < 50; i+=3)
			System.out.print(list3.get(i));

		//output
		//036912......424548
		System.out.println();

		for(int i = 0; i < 50; i+=3)
			System.out.print(list3.set(i, 0));//issue starts here

		//output
		//036912......424548
		System.out.println();
		System.out.println(list3);
		for(int i = 49; i > 0; i-=3)
			System.out.print(list3.remove(i));

		//output
		//49464340.......
		System.out.println();

		System.out.println(list3.size());
		System.out.println(list3);
		//output
		//33
		//[0, 2, 0, 5, 0, 8, 0, 11, 0, 14, 0, 17, 0, 20, 0, 23, 0, 26, 0, 29, 0, 32, 0, 35, 0, 38, 0, 41, 0, 44, 0, 47, 0]


		System.out.println();
		System.out.println(list3.remove(0));
		System.out.println(list3.set(0,100));
		System.out.println(list3);
		//output
		//0
		//2
		//[100, 0, 5, 0, 8......47, 0]


	}
}