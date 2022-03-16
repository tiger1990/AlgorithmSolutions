package array.algo_company.DataStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class PhoneBillCalculator {
    private static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final int ONE_MIN_IN_SECONDS = 60;

    private static final Integer FIVE_MINUTE_LIMIT = 300;
    private static final Integer CENTS_PER_SECOND = 3;
    private static final Integer CENTS_PER_SEC_AFTER_FIVE_MINUTE_LIMIT = 150;


    public static void main(String... args) {
        String INPUT = "00:01:07,400-234-090\n" +
                "00:06:07,701-080-080\n" +
                "00:05:00,400-234-090";
        System.out.println(new PhoneBillCalculator().calculatePhoneBill(INPUT));
    }


    private static final Comparator<List<CallData>> PHONE_CALL_LIST_COMPARATOR = (l1, l2) ->
    {
        int comparedValue = -1 * l1.stream()
                .map(callData -> callData.seconds)
                .reduce(0, (second, addedSecond) -> second + addedSecond)
                .compareTo(
                        l2.stream()
                        .map(callData -> callData.seconds)
                        .reduce(0, (second, addedSecond) -> second + addedSecond)
                );

        return comparedValue == 0 //This is important! The duration between two sets of calls could be the same, but the cost calc could be very different!
                ? l1.stream().findFirst().get().phoneNumber.replace("-", "")
                .compareTo(l2.stream().findFirst().get().phoneNumber.replace("-", ""))
                : comparedValue;
    };


    public int calculatePhoneBill(String csvString) {
        return Arrays.stream(csvString.split("\r?\n"))
                .map(x -> x.split(","))
                .map(Arrays::asList)
                .map(CallData::new) //Stream<PhoneCall>
                .collect(Collectors.groupingBy(callData -> callData.phoneNumber)) //Map<String, List<PhoneCall>>
                .values() //Only deal with the grouped phone numbers
                .stream()
                .sorted(PHONE_CALL_LIST_COMPARATOR) //Sort by longest duration/phone number
                .skip(1) //Remove the longest total duration
                .flatMap(List::stream) //flat map to a list of calls
                .reduce(0, (curCost, call) -> curCost + calculateCallCost(call) , (curCost, addCost) -> curCost + addCost); //Return the total cost of all calls, calculated individually
    }

    private int calculateCallCost(CallData callData) {
        return callData.totalSeconds >= FIVE_MINUTE_LIMIT ?
                ((callData.hours * 60) + (callData.minutes) + (callData.seconds > 0 ? 1 : 0))
                        * CENTS_PER_SEC_AFTER_FIVE_MINUTE_LIMIT
                : ((callData.minutes * 60) + (callData.seconds)) * CENTS_PER_SECOND;
    }

    private static class CallData {
        final int hours;
        final int minutes;
        final int seconds;
        final int totalSeconds;
        final String phoneNumber;

        CallData(List<String> logList) {
            phoneNumber = logList.get(1);
            String[] durationArray = logList.get(0).split(":");
            hours = Integer.valueOf(durationArray[0]);
            minutes = Integer.valueOf(durationArray[1]);
            seconds = Integer.valueOf(durationArray[2]);
            totalSeconds = (hours * ONE_HOUR_IN_SECONDS) + (minutes * ONE_MIN_IN_SECONDS) + (seconds);
        }
    }
}



