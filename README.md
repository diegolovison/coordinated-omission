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
- https://github.com/rvansa/radargun/blob/29704d2d9a72acc39453db1c4ebf25b9dde7d0c2/docs/measuring_performance/coordinated_omission.md

### Next versions
- Plot the results into a graph
- Combine both graph into one

### Output Sample
```
Coordinate Omission
======= Latency =======
Operations: 12223
AverageLatency(us): 4904.766141209196
MinLatency(us): 4014
MaxLatency(us): 11010
95thPercentileLatency(ms): 5
99thPercentileLatency(ms): 5

Fix Coordinate Omission
======= Latency =======
Operations: 12540
AverageLatency(us): 4987117.470009569
MinLatency(us): 4653
MaxLatency(us): 9865003
95thPercentileLatency(ms): 9059
99thPercentileLatency(ms): 9797

Process finished with exit code 0
 ```