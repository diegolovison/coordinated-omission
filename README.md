Learning about Coordinated Omission
===================================

### Information about Coordinated Omission

- https://www.youtube.com/watch?v=lJ8ydIuPFeU
- http://highscalability.com/blog/2015/10/5/your-load-generator-is-probably-lying-to-you-take-the-red-pi.html
- https://news.ycombinator.com/item?id=10334335
- http://www.rationaljava.com/2015/05/simple-class-to-measure-latency.html
- https://www.infoq.com/presentations/latency-pitfalls
- http://www.rationaljava.com/2015/07/the-effect-of-co-ordinated-omission.html
- https://dzone.com/articles/everything-you-know-about-latency-is-wrong-brave-n
- https://groups.google.com/forum/#!msg/mechanical-sympathy/icNZJejUHfE/BfDekfBEs_sJ
- http://psy-lob-saw.blogspot.com.br/2015/03/fixing-ycsb-coordinated-omission.html
- https://www.slideshare.net/PeterLawrey/low-latency-for-high-throughput
- https://www.youtube.com/watch?v=9MKY4KypBzg
- http://psy-lob-saw.blogspot.com.br/2015/02/hdrhistogram-better-latency-capture.html
- https://shipilev.net/blog/2014/nanotrusting-nanotime/

### Next versions
- Plot the results into a graph
- Combine both graph into one
- Find out how rate `MeasureLatency::rate` will behave when using a time running instead of a fixed throughput

### Output Sample
```
Starting latency test rate 200000 using coordinated omission: true 
 Latency measured : 
 10000000 operations
 0,20 us for average latency
 0,02 us for min latency
 0,17 us for 50 percentile
 0,25 us for 90 percentile
 0,51 us for 99 percentile
 1,34 us for 99.9 percentile
 12,29 us for 99.99 percentile
 14417,92 us for max latency

Starting latency test rate 200000 using coordinated omission: false 
 Latency measured : 
 10000000 operations
 0,67 us for average latency
 0,02 us for min latency
 0,23 us for 50 percentile
 0,40 us for 90 percentile
 0,51 us for 99 percentile
 3,31 us for 99.9 percentile
 1589,25 us for 99.99 percentile
 4112,38 us for max latency

Starting latency test rate 160000 using coordinated omission: true 
 Latency measured : 
 10000000 operations
 0,15 us for average latency
 0,02 us for min latency
 0,11 us for 50 percentile
 0,29 us for 90 percentile
 0,54 us for 99 percentile
 2,03 us for 99.9 percentile
 14,98 us for 99.99 percentile
 3964,93 us for max latency

Starting latency test rate 160000 using coordinated omission: false 
 Latency measured : 
 10000000 operations
 2,88 us for average latency
 0,02 us for min latency
 0,24 us for 50 percentile
 0,41 us for 90 percentile
 0,71 us for 99 percentile
 802,82 us for 99.9 percentile
 4063,23 us for 99.99 percentile
 6914,05 us for max latency

Starting latency test rate 140000 using coordinated omission: true 
 Latency measured : 
 10000000 operations
 0,31 us for average latency
 0,02 us for min latency
 0,37 us for 50 percentile
 0,41 us for 90 percentile
 0,53 us for 99 percentile
 1,86 us for 99.9 percentile
 14,46 us for 99.99 percentile
 2670,59 us for max latency

Starting latency test rate 140000 using coordinated omission: false 
 Latency measured : 
 10000000 operations
 0,85 us for average latency
 0,02 us for min latency
 0,24 us for 50 percentile
 0,40 us for 90 percentile
 0,55 us for 99 percentile
 6,98 us for 99.9 percentile
 2260,99 us for 99.99 percentile
 7307,26 us for max latency

Starting latency test rate 120000 using coordinated omission: true 
 Latency measured : 
 10000000 operations
 0,32 us for average latency
 0,02 us for min latency
 0,36 us for 50 percentile
 0,41 us for 90 percentile
 0,52 us for 99 percentile
 1,28 us for 99.9 percentile
 12,74 us for 99.99 percentile
 2490,37 us for max latency

Starting latency test rate 120000 using coordinated omission: false 
 Latency measured : 
 10000000 operations
 1,68 us for average latency
 0,02 us for min latency
 0,24 us for 50 percentile
 0,40 us for 90 percentile
 0,53 us for 99 percentile
 76,29 us for 99.9 percentile
 3735,55 us for 99.99 percentile
 7995,39 us for max latency

Starting latency test rate 100000 using coordinated omission: true 
 Latency measured : 
 10000000 operations
 0,32 us for average latency
 0,02 us for min latency
 0,29 us for 50 percentile
 0,38 us for 90 percentile
 0,52 us for 99 percentile
 2,90 us for 99.9 percentile
 17,79 us for 99.99 percentile
 17563,65 us for max latency

Starting latency test rate 100000 using coordinated omission: false 
 Latency measured : 
 10000000 operations
 4,65 us for average latency
 0,02 us for min latency
 0,24 us for 50 percentile
 0,41 us for 90 percentile
 0,76 us for 99 percentile
 1261,57 us for 99.9 percentile
 7831,55 us for 99.99 percentile
 12779,52 us for max latency
 ```