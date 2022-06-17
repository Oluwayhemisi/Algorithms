package africa.semicolon.true_caller.data.models;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor


public class Contact {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String phoneNumber;
    private int id;
}
